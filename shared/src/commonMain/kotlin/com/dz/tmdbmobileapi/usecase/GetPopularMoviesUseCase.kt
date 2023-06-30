package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.remote.responses.MoviesResponse
import com.dz.tmdbmobileapi.remote.GetPopularMoviesDataSource

class GetPopularMoviesUseCase(private val popularMoviesDataSource: GetPopularMoviesDataSource) {
    suspend operator fun invoke(): Resource<MoviesResponse> {
        return popularMoviesDataSource.getPopularMovies(1)
    }
}