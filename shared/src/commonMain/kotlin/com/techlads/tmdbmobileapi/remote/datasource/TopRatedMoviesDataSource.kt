package com.techlads.tmdbmobileapi.remote.datasource

import com.techlads.tmdbmobileapi.base.Constants
import com.techlads.tmdbmobileapi.base.Resource
import com.techlads.tmdbmobileapi.remote.NetworkClient
import com.techlads.tmdbmobileapi.remote.NetworkClient.safeGet
import com.techlads.tmdbmobileapi.remote.Params
import com.techlads.tmdbmobileapi.remote.responses.MoviesResponse


class TopRatedMoviesDataSource(private val network: NetworkClient) {

    suspend fun get(
        page: Int = 1,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<MoviesResponse> {

        val url = Constants.BASE_URL + "movie/top_rated"

        return network.httpClient.safeGet(url, Params().apply {
            put("page", page.toString())
            put("api_key", apiKey)
            put("language", language)
        })
    }
}