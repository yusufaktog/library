package com.aktog.library.dto


import com.aktog.library.entity.Gender
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDate

data class ReaderDto @JvmOverloads constructor(
    val id: String? = "",
    val name: String,
    val email: String,
    val gender: Gender,
    val dateOfBirth: LocalDate,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val favoriteBooks: List<BookDto>? = ArrayList(),

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val friends: List<ReaderDto>? = ArrayList()

)
