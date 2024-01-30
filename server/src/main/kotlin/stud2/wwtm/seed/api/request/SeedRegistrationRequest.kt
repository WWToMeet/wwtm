package stud2.wwtm.seed.api.request

data class SeedRegistrationRequest(
    val masterUserHash: String,
    val participants: Int,
    val timeRange: Int
)
