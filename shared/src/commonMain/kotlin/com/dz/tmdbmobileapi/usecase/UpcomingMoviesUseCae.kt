package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.UpcomingMoviesDataSource

class UpcomingMoviesUseCae(private val dataSource: UpcomingMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
