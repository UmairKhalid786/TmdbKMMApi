package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TrendingTvSeriesDataSource

class TrendingTvSeriesUseCae(private val dataSource: TrendingTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
