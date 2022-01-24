package com.aktog.library.dto.request.update

import com.aktog.library.entity.Gender
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UpdateReaderRequest  (
    @field:NotBlank
    val name: String,

    @field:Email
    val email: String,

    val gender: Gender,
)