package com.aktog.library.dto.request.create

import com.aktog.library.entity.Author
import com.aktog.library.entity.Genre
import java.time.LocalDate
import javax.validation.constraints.*

data class CreateBookRequest(

    @field:NotBlank
    val title: String,

    @field:Max(10000)
    @field:Min(1)
    val bookmark: Int? = 1,

    @Past
    val releaseDate: LocalDate,

    @field:NotBlank
    val language: String,

    @field:NotNull
    val genres: List<Genre>,

    @field:NotBlank
    val imageUrl: String,

    @field:Min(0L)
    @field:Max(10L)
    val rate: Double,

    @field:NotNull
    val authorId: String,

    @field:NotBlank
    val content: String
)