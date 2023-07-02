package com.techlads.tmdbmobileapi.remote.responses

import com.techlads.tmdbmobileapi.remote.dto.Genre
import kotlinx.serialization.SerialName

data class GenresResponse(
    @SerialName("genres")
    val genres: List<Genre>
)