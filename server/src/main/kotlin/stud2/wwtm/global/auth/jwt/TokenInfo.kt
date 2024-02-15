package stud2.wwtm.global.auth.jwt

data class TokenInfo(
    val grantType: String,
    val accessToken: String,
)
