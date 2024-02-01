package stud2.wwtm.global.auth.jwt

import io.jsonwebtoken.*
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtTokenProvider (
    private val jwtProperties: JwtProperties
) {
    private val key by lazy {
        Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.secret))
    }

    fun createToken(authentication: Authentication): TokenInfo {
        val authorities: String = authentication.authorities.joinToString(",", transform = GrantedAuthority::getAuthority)
        val now = Date()
        val accessTokenExpirationDate = Date(now.time + jwtProperties.expirationTime)

        val accessToken = Jwts.builder()
            .setSubject(authentication.principal as String)
            .claim("authorities", authorities)
            .setIssuedAt(now)
            .setExpiration(accessTokenExpirationDate)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact()
        return TokenInfo("Bearer", accessToken)
    }

    fun getAuthentication(token: String): Authentication {
        val claims: Claims = getClaims(token)
        val auth = claims["authorities"] ?: throw RuntimeException("유효하지 않은 토큰입니다.")

        val authorities: Collection<GrantedAuthority> = (auth as String).split(",").map { SimpleGrantedAuthority (it) }
        val principal: UserDetails = User(claims.subject, "", authorities)

        return UsernamePasswordAuthenticationToken(principal, "", authorities)
    }

    private fun getClaims(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .body
    }

    fun validateToken(token: String): Boolean {
        try {
            getClaims(token)
            return true
        } catch (e: Exception) {
            when (e) {
                is SecurityException -> {throw RuntimeException("유효하지 않은 토큰입니다.")}
                is MalformedJwtException -> {throw RuntimeException("유효하지 않은 토큰입니다.")}
                is ExpiredJwtException -> {throw RuntimeException("만료된 토큰입니다.")}
                is UnsupportedJwtException -> {throw RuntimeException("지원하지 않는 토큰입니다.")}
                is IllegalArgumentException -> {throw RuntimeException("유효하지 않은 토큰입니다.")}
                else -> {throw RuntimeException("토큰 검증 오류")}  // else
            }
        }
        return false
    }
}
