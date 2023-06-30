package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.PopularMoviesDataSource

class GetPopularMoviesUseCase(private val popularMoviesDataSource: PopularMoviesDataSource) {
    suspend operator fun invoke() = popularMoviesDataSource.getPopularMovies(1)
}