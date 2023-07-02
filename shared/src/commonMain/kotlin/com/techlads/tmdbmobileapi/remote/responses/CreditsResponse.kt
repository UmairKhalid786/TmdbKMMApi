package com.techlads.tmdbmobileapi.remote.responses

import com.techlads.tmdbmobileapi.remote.dto.Cast
import kotlinx.serialization.SerialName

data class CreditsResponse(
    @SerialName("cast")
    val cast: List<Cast>,
    @SerialName("id")
    val id: Int
)