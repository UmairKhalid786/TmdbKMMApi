package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.PopularMoviesDataSource

class PopularMoviesUseCase(private val dataSource: PopularMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get(1)
}