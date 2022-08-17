package com.aktog.library.dto


import com.aktog.library.entity.Gender
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

data class AuthorDto @JvmOverloads constructor(
    val id: String? = "",
    val name: String,
    val email: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,

    @JsonInclude(JsonInclude.Include.NON_NULL)
    val books: List<BookDto>? = ArrayList()
)