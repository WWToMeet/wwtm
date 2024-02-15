package stud2.wwtm.domain.user.error

import stud2.wwtm.global.exception.ErrorCode

enum class UserErrorCode (
    private var status: Int,
    private var message: String
): ErrorCode {
    CONFLICT_ALREADY_EXIST(409, "이미 존재하는 사용자입니다."),
    NOT_FOUND_NON_EXISTENT_USER(404, "존재하지 않는 사용자입니다."),
    CONFLICT_NOT_MATCH_PASSWORD(409, "비밀번호가 일치하지 않습니다.");

    override fun getStatus(): Int {
        return status
    }

    override fun getMessage(): String {
        return message
    }
}
