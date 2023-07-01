package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TrendingTodayMoviesDataSource

class TrendingTodayMoviesUseCae(private val dataSource: TrendingTodayMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}