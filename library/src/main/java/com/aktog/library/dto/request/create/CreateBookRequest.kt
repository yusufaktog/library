package com.aktog.library.dto.request.create

import com.aktog.library.entity.Author
import com.aktog.library.entity.Genre
import org.springframework.beans.factory.annotation.Value
import java.time.LocalDate
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.*
import kotlin.math.max

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
    val author: Author,

    @field:NotBlank
    val content: String
)