package com.aktog.library.dto.request.update

import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class UpdateBookRequest(

    @field:NotBlank
    val title: String,

    @field:Min(value = 0)
    val bookmark: Int,

    @field:NotBlank
    val imageUrl: String,

    @field:Min(0L)
    @field:Max(10L)
    val rate: Double,

    )