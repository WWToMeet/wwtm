package stud2.wwtm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class WwtmApplication

fun main(args: Array<String>) {
    runApplication<WwtmApplication>(*args)
}
