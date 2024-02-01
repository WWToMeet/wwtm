package stud2.wwtm.global.auth.model

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import stud2.wwtm.domain.user.model.User

class CustomUserDetails (
    val nickname: String,
    val hashId: String,
    val grantedAuthorities: List<GrantedAuthority>
): UserDetails {

    constructor(user: User) : this(user.nickname, user.hashId!!,
        if (user == null) { listOf(SimpleGrantedAuthority("GUEST")) } else { listOf(SimpleGrantedAuthority("USER")) }
    )

    fun getHashId(): String {
        return hashId
    }

    fun getNickname(): String {
        return nickname
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return grantedAuthorities.toMutableList()
    }

    override fun getPassword(): String {
        return null!!
    }

    override fun getUsername(): String {
        return nickname
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}
