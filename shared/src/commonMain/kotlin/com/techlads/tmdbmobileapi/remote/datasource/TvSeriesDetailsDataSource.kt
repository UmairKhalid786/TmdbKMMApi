package com.techlads.tmdbmobileapi.remote.datasource

import com.techlads.tmdbmobileapi.base.Constants
import com.techlads.tmdbmobileapi.base.Resource
import com.techlads.tmdbmobileapi.remote.NetworkClient
import com.techlads.tmdbmobileapi.remote.NetworkClient.safeGet
import com.techlads.tmdbmobileapi.remote.Params
import com.techlads.tmdbmobileapi.remote.responses.TvSeriesDetails


class TvSeriesDetailsDataSource(private val network: NetworkClient) {
    suspend fun get(
        tvSeriesId: Int,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<TvSeriesDetails> {

        val url = Constants.BASE_URL + "tv/$tvSeriesId"

        return network.httpClient.safeGet(url, Params().apply {
            put("api_key", apiKey)
            put("language", language)
        })
    }
}