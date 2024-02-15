package stud2.wwtm.domain.auth

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.stereotype.Component
import stud2.wwtm.domain.auth.error.AuthErrorCode
import stud2.wwtm.global.dto.CommonResponse
import stud2.wwtm.global.dto.ErrorResponse
import stud2.wwtm.global.exception.ErrorCode
import java.io.IOException


@Component
class AuthExceptionHandler : AuthenticationEntryPoint, AccessDeniedHandler, AuthenticationFailureHandler {

    @Throws(IOException::class)
    private fun throwAuthException(response: HttpServletResponse, errorCode: ErrorCode) {
        val commonResponse: CommonResponse = CommonResponse(
            error = ErrorResponse(errorCode = errorCode.getStatus(), errorMessage = errorCode.getMessage()))
        val exceptionResponseJson = ObjectMapper().writeValueAsString(commonResponse)
        response.status = errorCode.getStatus()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = "utf-8"
        val write = response.writer
        write.write(exceptionResponseJson)
        write.flush()
    }

    override fun commence(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authException: AuthenticationException?
    ) {
        throwAuthException(response!!, AuthErrorCode.UNAUTHORIZED)
    }

    override fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        accessDeniedException: AccessDeniedException?
    ) {
        throwAuthException(response!!, AuthErrorCode.FORBIDDEN)
    }

    override fun onAuthenticationFailure(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        exception: AuthenticationException?
    ) {
        TODO("Not yet implemented")
    }
}
