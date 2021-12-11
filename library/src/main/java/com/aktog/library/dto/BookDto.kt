package com.aktog.library.dto

import com.aktog.library.entity.Genre
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

data class BookDto(
    val id: String? = "",
    val title: String,
    val releaseDate: LocalDate,
    val genres: List<Genre>,
    val language: String,
    val rate: Double,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val author: AuthorDto? = null

)

