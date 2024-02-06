package stud2.wwtm.domain.user.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import stud2.wwtm.domain.user.dto.SignUpRequest
import stud2.wwtm.domain.user.error.UserErrorCode
import stud2.wwtm.domain.user.repository.UserRepository
import stud2.wwtm.global.exception.BusinessException

@Service
@Transactional(readOnly = true)
class UserService (
    private val userRepository: UserRepository,
) {
    @Transactional
    fun singUp(singUpRequest: SignUpRequest) {
        userRepository.findByUsername(singUpRequest.username)
            ?.let { throw BusinessException(UserErrorCode.CONFLICT_ALREADY_EXIST) }
            ?: userRepository.save(singUpRequest.toEntity()).id
    }
}
