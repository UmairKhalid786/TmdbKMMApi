package com.dz.tmdbmobileapi.data.responses

import com.dz.tmdbmobileapi.data.model.Cast
import kotlinx.serialization.SerialName

data class CreditsResponse(
    @SerialName("cast")
    val cast: List<Cast>,
    @SerialName("id")
    val id: Int
)