package com.techlads.tmdbmobileapi.usecase

import com.techlads.tmdbmobileapi.remote.datasource.TvSeriesCreditsDataSource

class TvSeriesCreditsUseCae(private val dataSource: TvSeriesCreditsDataSource) {
    suspend operator fun invoke(tvSeriesId: Int) = dataSource.get(tvSeriesId)
}
