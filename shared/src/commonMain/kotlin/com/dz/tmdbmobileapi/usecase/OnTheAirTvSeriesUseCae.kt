package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.OnTheAirTvSeriesDataSource

class OnTheAirTvSeriesUseCae(private val dataSource: OnTheAirTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
