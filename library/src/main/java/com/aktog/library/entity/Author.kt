package com.aktog.library.entity

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Author @JvmOverloads constructor(
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val name: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    val books: List<Book>? = ArrayList(),

    ) {
    enum class Gender {
        MALE, FEMALE, UNKNOWN
    }
}
