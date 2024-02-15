package stud2.wwtm.domain.user.model

fun createdHashId(username: String): String {
    //TODO: fix
    return username.hashCode().toString().substring(0, 6)
}

