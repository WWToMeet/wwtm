package stud2.wwtm.global.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import stud2.wwtm.global.dto.CommonResponse
import stud2.wwtm.global.dto.ErrorResponse

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException( e: BusinessException, request: HttpServletRequest ): ResponseEntity<CommonResponse> {
        val errorCode = e.errorCode
        val commonResponse = CommonResponse(error = ErrorResponse(errorCode = errorCode.getStatus(), errorMessage = errorCode.getMessage()))
        return ResponseEntity.status(errorCode.getStatus()).body(commonResponse)
    }
}
