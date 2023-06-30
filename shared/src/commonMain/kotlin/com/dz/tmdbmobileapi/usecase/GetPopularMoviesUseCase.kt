package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.remote.responses.MoviesResponse
import com.dz.tmdbmobileapi.remote.PopularMoviesDataSource

class GetPopularMoviesUseCase(private val popularMoviesDataSource: PopularMoviesDataSource) {
    suspend operator fun invoke(): Resource<MoviesResponse> {
        return popularMoviesDataSource.getPopularMovies(1)
    }
}