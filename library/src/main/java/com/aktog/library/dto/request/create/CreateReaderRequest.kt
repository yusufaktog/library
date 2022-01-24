package com.aktog.library.dto.request.create

import com.aktog.library.entity.Gender
import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Past

data class CreateReaderRequest(

    @field:NotBlank
    val name: String,

    @field:Email
    val email: String,

    val gender: Gender,

    @field:Past
    val dateOfBirth: LocalDate
)