package com.dz.tmdbmobileapi.remote.datasource

import com.dz.tmdbmobileapi.base.Constants.BASE_URL
import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.remote.NetworkClient
import com.dz.tmdbmobileapi.remote.NetworkClient.safeGet
import com.dz.tmdbmobileapi.remote.Params
import com.dz.tmdbmobileapi.remote.responses.CreditsResponse


class MovieCreditsDataSource(private val network: NetworkClient) {
    suspend fun get(
        movieId: Int,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<CreditsResponse> {

        val url = BASE_URL + "movie/$movieId/credits"

        return network.httpClient.safeGet(url, Params().apply {
            put("api_key", apiKey)
            put("language", language)
        })
    }
}