package stud2.wwtm.seed.service

import jakarta.transaction.Transactional
import org.hibernate.query.sqm.tree.SqmNode.log
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import stud2.wwtm.seed.api.request.SeedRegistrationRequest
import stud2.wwtm.seed.api.request.SeedUpdateRequest
import stud2.wwtm.seed.model.Seed
import stud2.wwtm.seed.repository.SeedRepository
import stud2.wwtm.seed.service.dto.SeedDto

@Service
class SeedService (
    private val seedRepository: SeedRepository
) {

    fun register(request: SeedRegistrationRequest) {
        val seed = Seed(
            masterUserHash = request.masterUserHash,
            participants = request.participants,
            timeRange = request.timeRange,
        )

        seedRepository.save(seed).also { log.info { "Seed Registration, id: ${seed.id}" } }
    }

    fun retrieve(id: Long): SeedDto {
        val seed = seedRepository.findByIdOrNull(id) ?: throw RuntimeException()

        return SeedDto.from(seed)
    }

    @Transactional
    fun update(id: Long, request: SeedUpdateRequest): SeedDto {
        val seed = seedRepository.findByIdOrNull(id) ?: throw RuntimeException()
        if (request.participants != null)
            seed.updateParticipants(request.participants);
        if (request.timeRange != null)
            seed.updateTimeRange(request.timeRange);
        /**
         * TODO: update users
         */

        return SeedDto.from(seed)
    }

    @Transactional
    fun makeReady(id: Long) {
        val seed = seedRepository.findByIdOrNull(id) ?: throw RuntimeException()
        seed.makeReady()
    }
}
