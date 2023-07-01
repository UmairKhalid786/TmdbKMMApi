package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.MovieDetailsDataSource

class MovieDetailsUseCae(private val dataSource: MovieDetailsDataSource) {
    suspend operator fun invoke(movieId: Int) = dataSource.get(movieId)
}
