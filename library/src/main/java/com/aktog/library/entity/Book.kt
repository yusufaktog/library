package com.aktog.library.entity

import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Book @JvmOverloads constructor(

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String = "",
    val title: String,
    val releaseDate: LocalDate,
    val language: String,
    val genres: List<Genre>,
    val rate: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    val author: Author,

)
