package com.dz.tmdbmobileapi.data.responses

import com.dz.tmdbmobileapi.data.model.Series
import kotlinx.serialization.SerialName

data class TvSeriesResponse(
    @SerialName("page")
    val page: Int,
    @SerialName("results")
    val results: List<Series>,
    @SerialName("total_pages")
    val total_pages: Int,
    @SerialName("total_results")
    val total_results: Int
)