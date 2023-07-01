package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.PopularTvSeriesDataSource

class PopularTvSeriesUseCae(private val dataSource: PopularTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
