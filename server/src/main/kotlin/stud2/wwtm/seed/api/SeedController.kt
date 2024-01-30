package stud2.wwtm.seed.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import stud2.wwtm.seed.api.request.SeedRegistrationRequest
import stud2.wwtm.seed.api.request.SeedUpdateRequest
import stud2.wwtm.seed.service.SeedService

@RestController("/seeds")
class SeedController (
    private val seedService: SeedService
)   {

    @PostMapping
    fun register(@RequestBody request: SeedRegistrationRequest) : ResponseEntity<Unit>{
        seedService.register(request)

        return ResponseEntity.ok().build()
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody request: SeedUpdateRequest) : ResponseEntity<Unit> {
        seedService.update(id, request)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/{id}/ready")
    fun ready(@PathVariable id: Long) : ResponseEntity<Unit> {
        seedService.makeReady(id)
        return ResponseEntity.ok().build()
    }
}
