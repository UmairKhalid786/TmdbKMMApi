package com.dz.tmdbmobileapi.local.data.model

import kotlinx.serialization.SerialName

data class Genre(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)