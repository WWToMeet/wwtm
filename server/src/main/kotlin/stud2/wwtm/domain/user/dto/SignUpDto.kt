package stud2.wwtm.domain.user.dto

import jakarta.validation.constraints.NotBlank
import stud2.wwtm.domain.user.model.User

data class SignUpRequest(
    @field:NotBlank(message = "사용자 이름은 빈칸일 수 없습니다.")
    val username: String,
    @field:NotBlank(message = "닉네임은 빈칸일 수 없습니다.")
    val nickname: String,
    @field:NotBlank(message = "비밀번호는 빈칸일 수 없습니다.")
    val password: String,
) {

    fun toEntity(encodePassword: String) = User(
        id = null,
        hashId = null,
        username = username,
        nickname = nickname,
        password = encodePassword,
    )
}
