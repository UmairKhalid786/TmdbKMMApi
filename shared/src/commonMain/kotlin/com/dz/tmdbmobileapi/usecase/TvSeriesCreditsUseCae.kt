package com.dz.tmdbmobileapi.usecase

import com.dz.tmdbmobileapi.remote.datasource.TvSeriesCreditsDataSource

class TvSeriesCreditsUseCae(private val dataSource: TvSeriesCreditsDataSource) {
    suspend operator fun invoke(tvSeriesId: Int) = dataSource.get(tvSeriesId)
}
