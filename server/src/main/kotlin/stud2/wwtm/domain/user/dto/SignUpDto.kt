package stud2.wwtm.domain.user.dto

import stud2.wwtm.domain.user.model.User

data class SignUpRequest(
    val username: String,
    val nickname: String,
    val password: String,
) {

    fun toEntity() = User(
        id = null,
        hashId = null,
        username = username,
        nickname = nickname,
        password = password,
    )
}
