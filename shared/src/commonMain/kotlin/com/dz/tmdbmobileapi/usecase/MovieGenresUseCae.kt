package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.MovieGenresDataSource

class MovieGenresUseCae(private val dataSource: MovieGenresDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
