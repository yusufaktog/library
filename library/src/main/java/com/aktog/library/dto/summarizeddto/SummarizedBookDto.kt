package com.aktog.library.dto.summarizeddto

import com.aktog.library.entity.Genre
import java.time.LocalDate

data class SummarizedBookDto (
    val id: String? = "",
    val title: String,
    val language: String,
    val rate: Double,
)
