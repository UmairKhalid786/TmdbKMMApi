package com.dz.tmdbmobileapi.remote

import com.dz.tmdbmobileapi.base.Constants.BASE_URL
import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.remote.responses.MoviesResponse
import com.dz.tmdbmobileapi.remote.NetworkClient.safeGet


class GetPopularMoviesDataSource(private val network: NetworkClient) {

    suspend fun getPopularMovies(
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