package com.aktog.library.dto.request.create

import com.aktog.library.entity.Book
import com.aktog.library.entity.Gender
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past

data class CreateAuthorRequest(

    @field:NotBlank
    val name: String,

    @field:Email
    val email: String,

    @field:Past
    val dateOfBirth: LocalDate,

    val gender: Gender,

    val books: List<Book>?

)