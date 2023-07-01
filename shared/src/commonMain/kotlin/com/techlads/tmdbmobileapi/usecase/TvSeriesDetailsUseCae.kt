package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TvSeriesDetailsDataSource

class TvSeriesDetailsUseCae(private val dataSource: TvSeriesDetailsDataSource) {
    suspend operator fun invoke(tvSeriesId: Int) = dataSource.get(tvSeriesId)
}
