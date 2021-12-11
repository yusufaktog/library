package com.aktog.library.entity

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Reader @JvmOverloads constructor(

    @Id
    @Column(name = "author_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val name: String,
    val email: String,
    val gender: Author.Gender,
    val dateOfBirth: LocalDate,
    val favoriteBooks: List<Book>? = ArrayList(),
    val friends: List<Reader>? = ArrayList()


)