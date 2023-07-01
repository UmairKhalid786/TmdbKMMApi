package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.MovieCreditsDataSource

class MovieCreditsUseCae(private val dataSource: MovieCreditsDataSource) {
    suspend operator fun invoke(movieId: Int) = dataSource.get(movieId)
}
