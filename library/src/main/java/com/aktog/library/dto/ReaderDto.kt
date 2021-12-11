package com.aktog.library.dto

import com.aktog.library.dto.summarizeddto.SummarizedBookDto
import com.aktog.library.entity.Author
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

data class ReaderDto(
    val id: String? = "",
    val name: String,
    val email: String,
    val gender: Author.Gender,
    val dateOfBirth: LocalDate,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val favoriteBooks: List<SummarizedBookDto>? = ArrayList(),

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val friends: List<ReaderDto>? = ArrayList()

)
