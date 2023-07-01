package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.MovieCreditsDataSource

class MovieCreditsUseCae(private val dataSource: MovieCreditsDataSource) {
    suspend operator fun invoke(movieId: Int) = dataSource.get(movieId)
}
