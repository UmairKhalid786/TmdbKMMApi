package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.AiringTodayTvSeriesDataSource

class AiringTodayTvSeriesUseCae(private val dataSource: AiringTodayTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
