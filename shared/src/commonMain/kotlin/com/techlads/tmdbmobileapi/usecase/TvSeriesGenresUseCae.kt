package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TvSeriesGenresDataSource

class TvSeriesGenresUseCae(private val dataSource: TvSeriesGenresDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
