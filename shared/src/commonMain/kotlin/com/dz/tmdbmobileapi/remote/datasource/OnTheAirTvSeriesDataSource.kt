package com.dz.tmdbmobileapi.remote.datasource

import com.dz.tmdbmobileapi.base.Constants.BASE_URL
import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.remote.NetworkClient
import com.dz.tmdbmobileapi.remote.NetworkClient.safeGet
import com.dz.tmdbmobileapi.remote.Params
import com.dz.tmdbmobileapi.remote.responses.MoviesResponse


class OnTheAirTvSeriesDataSource(private val network: NetworkClient) {
    suspend fun get(
        page: Int = 1,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<MoviesResponse> {

        val url = BASE_URL + "tv/on_the_air"

        return network.httpClient.safeGet(url, Params().apply {
            put("page", page.toString())
            put("api_key", apiKey)
            put("language", language)
        })
    }
}