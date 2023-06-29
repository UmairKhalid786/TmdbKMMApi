package com.dz.tmdbmobileapi.data.model

data class Favorite(
    val mediaId: Long,
    val mediaType: String,
    val image: String?,
    val favorite: Boolean?,
    val rating: Long,
    val title: String,
    val releaseDate: String
)