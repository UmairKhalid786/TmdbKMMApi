package com.dz.tmdbmobileapi.data.responses

import com.dz.tmdbmobileapi.data.model.Genre
import kotlinx.serialization.SerialName

data class GenresResponse(
    @SerialName("genres")
    val genres: List<Genre>
)