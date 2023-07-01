package com.techlads.tmdbmobileapi.remote.datasource

import com.techlads.tmdbmobileapi.base.Constants.BASE_URL
import com.techlads.tmdbmobileapi.base.Resource
import com.techlads.tmdbmobileapi.remote.NetworkClient
import com.techlads.tmdbmobileapi.remote.responses.MoviesResponse
import com.techlads.tmdbmobileapi.remote.NetworkClient.safeGet
import com.techlads.tmdbmobileapi.remote.Params

class PopularMoviesDataSource(private val network: NetworkClient) {

    suspend fun get(
        page: Int = 1,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<MoviesResponse> {

        val url = BASE_URL + "movie/popular"

        return network.httpClient.safeGet(url, Params().apply {
            put("page", page.toString())
            put("api_key", apiKey)
            put("language", language)
        })
    }
}