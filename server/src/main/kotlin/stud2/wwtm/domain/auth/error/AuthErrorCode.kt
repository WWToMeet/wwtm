package stud2.wwtm.domain.auth.error

import org.springframework.http.HttpStatus
import stud2.wwtm.global.exception.ErrorCode

enum class AuthErrorCode (
    private var status: Int,
    private var message: String
): ErrorCode {
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "인증되지 않은 사용자입니다."),
    FORBIDDEN(HttpStatus.FORBIDDEN.value(), "권한이 없는 사용자입니다.");

    override fun getStatus(): Int {
        return status
    }

    override fun getMessage(): String {
        return message
    }
}
