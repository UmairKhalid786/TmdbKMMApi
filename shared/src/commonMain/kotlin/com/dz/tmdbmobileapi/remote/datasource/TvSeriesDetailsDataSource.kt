package com.dz.tmdbmobileapi.remote.datasource

import com.dz.tmdbmobileapi.base.Constants
import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.remote.NetworkClient
import com.dz.tmdbmobileapi.remote.NetworkClient.safeGet
import com.dz.tmdbmobileapi.remote.Params
import com.dz.tmdbmobileapi.remote.responses.TvSeriesDetails


class TvSeriesDetailsDataSource(private val network: NetworkClient) {
    suspend fun get(
        tvSeriesId: Int,
        apiKey: String = "d31c90f6e90f1993a5cbce70c8c53ce8",
        language: String = "en"
    ): Resource<TvSeriesDetails> {

        val url = Constants.BASE_URL + "movie/$tvSeriesId"

        return network.httpClient.safeGet(url, Params().apply {
            put("api_key", apiKey)
            put("language", language)
        })
    }
}