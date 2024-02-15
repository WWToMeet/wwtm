package stud2.wwtm.global.exception

class BusinessException (
    private var errorCode: ErrorCode
) : RuntimeException(errorCode.getMessage())
