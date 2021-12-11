package com.aktog.library.dto

import com.aktog.library.entity.Author
import com.aktog.library.entity.Book
import java.time.LocalDate

data class AuthorDto(
    val id: String? = "",
    val name: String,
    val dateOfBirth: LocalDate,
    val gender: Author.Gender,
    val books: List<Book>? = ArrayList()
)