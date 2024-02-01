package stud2.wwtm.domain.user.repository

import org.springframework.data.jpa.repository.JpaRepository
import stud2.wwtm.domain.user.model.User

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}
