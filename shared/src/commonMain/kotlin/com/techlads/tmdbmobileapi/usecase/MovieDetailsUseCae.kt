package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.MovieDetailsDataSource

class MovieDetailsUseCae(private val dataSource: MovieDetailsDataSource) {
    suspend operator fun invoke(movieId: Int) = dataSource.get(movieId)
}
