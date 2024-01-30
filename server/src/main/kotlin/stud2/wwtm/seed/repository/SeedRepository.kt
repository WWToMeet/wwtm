package stud2.wwtm.seed.repository

import org.springframework.data.jpa.repository.JpaRepository
import stud2.wwtm.seed.model.Seed

interface SeedRepository : JpaRepository<Seed, Long> {
}
