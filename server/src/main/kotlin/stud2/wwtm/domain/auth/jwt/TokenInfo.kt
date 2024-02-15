package stud2.wwtm.domain.auth.jwt

data class TokenInfo(
    val grantType: String,
    val accessToken: String,
)
