package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.UpcomingMoviesDataSource

class UpcomingMoviesUseCae(private val dataSource: UpcomingMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
