package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TopRatedMoviesDataSource

class TopRatedMoviesUseCae(private val dataSource: TopRatedMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}