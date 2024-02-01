package stud2.wwtm.domain.user.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import stud2.wwtm.domain.user.dto.SignUpRequest
import stud2.wwtm.domain.user.service.UserService
import stud2.wwtm.global.dto.CommonResponse
import java.net.URI

@RestController
@RequestMapping("/api/users")
class UserController (
    private val userService: UserService,
) {

    @PostMapping
    fun signUp(@RequestBody singUpRequest: SignUpRequest): ResponseEntity<CommonResponse> {
        userService.singUp(singUpRequest)
        var uri: URI = URI.create("/api/me")

        return ResponseEntity.created(uri).body(CommonResponse())
    }
}
