package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.PopularTvSeriesDataSource

class PopularTvSeriesUseCae(private val dataSource: PopularTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
