package com.dz.tmdbmobileapi.remote.responses

import com.dz.tmdbmobileapi.local.data.model.Cast
import kotlinx.serialization.SerialName

data class CreditsResponse(
    @SerialName("cast")
    val cast: List<Cast>,
    @SerialName("id")
    val id: Int
)