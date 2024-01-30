package stud2.wwtm.seed.api.request

data class SeedUpdateRequest(
    val participants: Int?,
    val timeRange: Int?,
    val userIds: List<Int>,
)
