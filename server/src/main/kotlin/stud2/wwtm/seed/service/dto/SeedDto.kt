package stud2.wwtm.seed.service.dto

import stud2.wwtm.seed.model.Seed

data class SeedDto(
    val id: Int,
    val masterUserHash: String,
    val participants: Int,
    val timeRange: Int,
) {
    companion object {
        fun from(entity: Seed): SeedDto = SeedDto(
            id = entity.id,
            masterUserHash = entity.masterUserHash,
            participants = entity.participants,
            timeRange = entity.timeRange,
        )
    }
}
