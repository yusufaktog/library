package com.aktog.library.dto

import com.aktog.library.entity.Genre
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

data class BookDto @JvmOverloads constructor(
    val id: String? = "",
    val bookmark: Int?,
    val content: String,
    val title: String,
    val releaseDate: LocalDate,
    val genres: List<Genre>,
    val language: String,
    val imageUrl: String?,
    val rate: Double,

    val authorId: String
)

