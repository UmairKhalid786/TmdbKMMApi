package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.AiringTodayTvSeriesDataSource

class AiringTodayTvSeriesUseCae(private val dataSource: AiringTodayTvSeriesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
