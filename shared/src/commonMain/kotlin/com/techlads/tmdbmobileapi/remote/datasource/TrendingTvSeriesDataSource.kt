package com.techlads.tmdbmobileapi.remote.datasource

import com.techlads.tmdbmobileapi.base.Constants.BASE_URL
import com.techlads.tmdbmobileapi.base.Resource
import com.techlads.tmdbmobileapi.remote.NetworkClient
import com.techlads.tmdbmobileapi.remote.NetworkClient.safeGet
import com.techlads.tmdbmobileapi.remote.Params
import com.techlads.tmdbmobileapi.remote.responses.TvSeriesResponse


class TrendingTvSeriesDataSource(private val network: NetworkClient) {
    suspend fun get(
        page: Int = 1,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<TvSeriesResponse> {

        val url = BASE_URL + "trending/tv/day"

        return network.httpClient.safeGet(url, Params().apply {
            put("page", page.toString())
            put("api_key", apiKey)
            put("language", language)
        })
    }
}