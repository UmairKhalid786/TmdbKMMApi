package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.NowPlayingMoviesDataSource

class NowPlayingMoviesUseCae(private val dataSource: NowPlayingMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}