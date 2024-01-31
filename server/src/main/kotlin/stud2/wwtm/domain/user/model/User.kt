package stud2.wwtm.domain.user.model

import jakarta.persistence.*
import stud2.wwtm.global.model.BaseEntity

@Entity
@Table(name = "users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column
    var hashId: String? = null,

    @Column
    var username: String? = null,

    @Column
    var nickname: String? = null,

    @Column
    var password: String? = null,

//    @Column
//    var locations: Location? = null,

//    @Column
//    var schedule: Schedule? = null,
) : BaseEntity()
