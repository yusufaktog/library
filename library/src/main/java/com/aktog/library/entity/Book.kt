package com.aktog.library.entity

import org.hibernate.Hibernate
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Book @JvmOverloads constructor(

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    val id: String? = "",
    val title: String,
    val content: String,
    val bookmark: Int? = 1,
    val releaseDate: LocalDate,
    val language: String,
    @field:ElementCollection
    val genres: List<Genre>,
    val imageUrl: String,
    val rate: Double,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    val author: Author,

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Book

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}
