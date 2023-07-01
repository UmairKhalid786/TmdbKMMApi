package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TopRatedTvSeriesDataSource

class TopRatedTvSeriesUseCae(private val dataSource: TopRatedTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
