package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TrendingTvSeriesDataSource

class TrendingTvSeriesUseCae(private val dataSource: TrendingTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
