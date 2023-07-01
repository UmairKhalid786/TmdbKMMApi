package com.techlads.tmdbmobileapi.remote.responses

import com.techlads.tmdbmobileapi.local.data.model.Cast
import kotlinx.serialization.SerialName

data class CreditsResponse(
    @SerialName("cast")
    val cast: List<Cast>,
    @SerialName("id")
    val id: Int
)