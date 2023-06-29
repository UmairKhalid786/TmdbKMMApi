package com.dz.tmdbmobileapi

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

interface Network {
    fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
}

expect fun getNetwork(): Network