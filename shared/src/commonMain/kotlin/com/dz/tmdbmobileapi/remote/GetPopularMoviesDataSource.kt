package com.dz.tmdbmobileapi.remote

import com.dz.tmdbmobileapi.base.Constants.BASE_URL
import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.local.data.responses.MoviesResponse
import com.dz.tmdbmobileapi.remote.NetworkClient.safeGet
import io.ktor.http.URLBuilder
import io.ktor.http.URLProtocol
import io.ktor.http.path


class GetPopularMoviesDataSource(private val network: NetworkClient) {

    suspend fun getPopularMovies(
        page: Int = 1,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<MoviesResponse> {

        val url = URLBuilder().apply {
            protocol = URLProtocol.HTTPS
            host = "api.themoviedb.org"
            path("3", "movie", "popular")
            parameters.append("page", page.toString())
            parameters.append("api_key", apiKey)
            parameters.append("language", language)
        }.build()

        return network.httpClient.safeGet(url.toString())
    }
}