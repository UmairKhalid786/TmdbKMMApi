package com.techlads.tmdbmobileapi.remote.dto

import kotlinx.serialization.SerialName

data class Genre(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String
)