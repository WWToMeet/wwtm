package stud2.wwtm.global.dto

import java.sql.Timestamp
import java.time.LocalDateTime

class CommonResponse (
    var error: ErrorResponse? = null,
    var data: Any? = null,
    var timestamp: Timestamp = Timestamp.valueOf(LocalDateTime.now())
)

class ErrorResponse (
    var errorCode: Int? = null,
    var errorMessage: String? = null
)
