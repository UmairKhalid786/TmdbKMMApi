package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TvSeriesGenresDataSource

class TvSeriesGenresUseCae(private val dataSource: TvSeriesGenresDataSource) {
    suspend operator fun invoke() = dataSource.get()
}
