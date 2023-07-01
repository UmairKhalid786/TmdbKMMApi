package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TopRatedTvSeriesDataSource

class TopRatedTvSeriesUseCae(private val dataSource: TopRatedTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
