package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.PopularMoviesDataSource

class PopularMoviesUseCase(private val dataSource: PopularMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get(1)
}