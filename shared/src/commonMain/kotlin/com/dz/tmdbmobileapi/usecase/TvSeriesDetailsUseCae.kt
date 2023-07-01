package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TvSeriesDetailsDataSource

class TvSeriesDetailsUseCae(private val dataSource: TvSeriesDetailsDataSource) {
    suspend operator fun invoke(tvSeriesId: Int) = dataSource.get(tvSeriesId)
}
