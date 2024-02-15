package stud2.wwtm.global.exception

class BusinessException (
    var errorCode: ErrorCode
) : RuntimeException(errorCode.getMessage())
