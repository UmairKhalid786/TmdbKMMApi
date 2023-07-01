package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.NowPlayingMoviesDataSource

class NowPlayingMoviesUseCae(private val dataSource: NowPlayingMoviesDataSource) {
    suspend operator fun invoke() = dataSource.get()
}