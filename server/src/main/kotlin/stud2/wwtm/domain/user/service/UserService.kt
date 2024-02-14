package stud2.wwtm.domain.user.service

import mu.KotlinLogging
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import stud2.wwtm.domain.user.dto.SignUpRequest
import stud2.wwtm.domain.user.error.UserErrorCode
import stud2.wwtm.domain.user.model.User
import stud2.wwtm.domain.user.repository.UserRepository
import stud2.wwtm.global.auth.jwt.JwtTokenProvider
import stud2.wwtm.global.auth.jwt.TokenInfo
import stud2.wwtm.global.exception.BusinessException

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    val log = KotlinLogging.logger{}
    @Transactional
    fun singUp(signUpRequest: SignUpRequest): TokenInfo {
        userRepository.findByUsername(signUpRequest.username)
            ?: { throw BusinessException(UserErrorCode.CONFLICT_ALREADY_EXIST) }
        val encodePassword = passwordEncoder.encode(signUpRequest.password)
        val user: User = userRepository.save(signUpRequest.toEntity(encodePassword))
        return jwtTokenProvider.createToken(user.hashId!!, user.password)
    }
}
