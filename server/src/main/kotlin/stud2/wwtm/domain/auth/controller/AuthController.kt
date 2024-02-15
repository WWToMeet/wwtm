package stud2.wwtm.domain.auth.controller

import jakarta.validation.Valid
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import stud2.wwtm.domain.auth.dto.LoginRequest
import stud2.wwtm.domain.auth.dto.SignUpRequest
import stud2.wwtm.domain.auth.service.AuthService
import stud2.wwtm.global.dto.CommonResponse
import java.net.URI

@RestController
@RequestMapping("/api/users")
class AuthController (
    private val authService: AuthService,
) {
    val log = KotlinLogging.logger{}

    @PostMapping
    fun signUp(@RequestBody @Valid singUpRequest: SignUpRequest): ResponseEntity<CommonResponse> {
        val tokenInfo = authService.singUp(singUpRequest)
        var uri: URI = URI.create("/api/me")

        return ResponseEntity.created(uri).body(CommonResponse(data = tokenInfo))
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid loginRequest: LoginRequest): ResponseEntity<CommonResponse> {
        val tokenInfo = authService.login(loginRequest)

        return ResponseEntity.ok(CommonResponse(data = tokenInfo))
    }
}
