package stud2.wwtm.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import stud2.wwtm.domain.user.dto.SignUpRequest
import stud2.wwtm.domain.user.repository.UserRepository

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository,
) {
    @Transactional
    fun singUp(singUpRequest: SignUpRequest) {
        userRepository.findByUsername(singUpRequest.username)
            ?.let { throw IllegalArgumentException("이미 존재하는 사용자입니다.") }
            ?: userRepository.save(singUpRequest.toEntity()).id
    }
}
