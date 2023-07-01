package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.MovieGenresDataSource

class MovieGenresUseCae(private val dataSource: MovieGenresDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
