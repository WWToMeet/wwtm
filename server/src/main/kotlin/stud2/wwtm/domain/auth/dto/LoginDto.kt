package stud2.wwtm.domain.auth.dto

import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @field:NotBlank(message = "사용자 이름은 빈칸일 수 없습니다.")
    val username: String,
    @field:NotBlank(message = "비밀번호는 빈칸일 수 없습니다.")
    val password: String,
)
