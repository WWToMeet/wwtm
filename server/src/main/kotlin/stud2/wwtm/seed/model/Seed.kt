package stud2.wwtm.seed.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.GenerationType

@Entity
class Seed (
    @Column
    var masterUserHash: String = "",

    @Column
    var participants: Int = 0,

    @Column
    var timeRange: Int = 0,

    @Column
    var ready: Boolean = false,

//    @ManyToOne(fetch = FetchType.LAZY)
//    var users: List<User>? = null;

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0;

    fun updateParticipants(participants: Int) {
        this.participants = participants
    }

    fun updateTimeRange(timeRange: Int) {
        this.timeRange = timeRange
    }

    fun makeReady() {
        this.ready = true
    }
}
