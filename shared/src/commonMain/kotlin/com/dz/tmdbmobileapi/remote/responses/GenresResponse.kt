package com.dz.tmdbmobileapi.remote.responses

import com.dz.tmdbmobileapi.local.data.model.Genre
import kotlinx.serialization.SerialName

data class GenresResponse(
    @SerialName("genres")
    val genres: List<Genre>
)