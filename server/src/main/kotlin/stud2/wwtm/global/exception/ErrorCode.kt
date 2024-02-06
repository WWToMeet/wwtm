package stud2.wwtm.global.exception

interface ErrorCode {
    fun getStatus(): Int
    fun getMessage(): String
}
