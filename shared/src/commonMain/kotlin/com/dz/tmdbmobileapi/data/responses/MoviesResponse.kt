package com.dz.tmdbmobileapi.data.responses

import com.dz.tmdbmobileapi.data.model.Movie
import kotlinx.serialization.SerialName

data class MoviesResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val searches: List<Movie>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)