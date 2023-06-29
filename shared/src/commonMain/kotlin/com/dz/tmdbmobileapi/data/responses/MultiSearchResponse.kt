package com.dz.tmdbmobileapi.data.responses

import com.dz.tmdbmobileapi.data.model.Search
import kotlinx.serialization.SerialName

data class MultiSearchResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val searches: List<Search>,
    @SerialName("total_pages")
    val totalPages: Int,
    @SerialName("total_results")
    val totalResults: Int
)