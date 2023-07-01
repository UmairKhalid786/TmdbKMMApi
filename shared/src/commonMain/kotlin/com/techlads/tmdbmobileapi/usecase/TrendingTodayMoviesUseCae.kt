package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TrendingTodayMoviesDataSource

class TrendingTodayMoviesUseCae(private val dataSource: TrendingTodayMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}