package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.MultiSearchDataSource

class MultiSearchUseCae(private val dataSource: MultiSearchDataSource) {
    suspend operator fun invoke(query: String) = dataSource.get(query)
}
