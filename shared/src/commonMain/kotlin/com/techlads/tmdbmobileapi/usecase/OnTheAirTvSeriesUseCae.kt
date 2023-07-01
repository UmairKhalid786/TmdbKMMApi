package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.OnTheAirTvSeriesDataSource

class OnTheAirTvSeriesUseCae(private val dataSource: OnTheAirTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
