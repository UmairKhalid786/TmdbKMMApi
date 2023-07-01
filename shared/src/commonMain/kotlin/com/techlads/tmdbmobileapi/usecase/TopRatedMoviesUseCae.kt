package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TopRatedMoviesDataSource

class TopRatedMoviesUseCae(private val dataSource: TopRatedMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}