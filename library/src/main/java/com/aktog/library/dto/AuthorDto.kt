package com.aktog.library.dto


import com.aktog.library.entity.Author
import com.aktog.library.entity.Gender

import java.time.LocalDate

data class AuthorDto @JvmOverloads constructor(
    val id: String? = "",
    val name: String,
    val email: String,
    val dateOfBirth: LocalDate,
    val gender: Gender,
    val books: List<BookDto>? = ArrayList()
)