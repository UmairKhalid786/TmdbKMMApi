package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.MultiSearchDataSource

class MultiSearchUseCae(private val dataSource: MultiSearchDataSource) {
    suspend operator fun invoke(query: String) = dataSource.get(query)
}
