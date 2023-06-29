package com.dz.tmdbmobileapi.data.db

import com.dz.tmdbmobileapi.DatabaseDriverFactory
import com.dz.tmdbmobileapi.data.model.Favorite
import com.techlads.AppDatabase

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    private val dbQuery = database.appDatabaseQueries

    internal fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllFavorite()
        }
    }

    internal fun getAllFavorite(): List<Favorite> {
        return dbQuery.selectAllFavoritesInfo(::mapLaunchSelecting).executeAsList()
    }

    private fun mapLaunchSelecting(
        mediaId: Long,
        mediaType: String,
        image: String?,
        favorite: Boolean?,
        rating: Long,
        title: String,
        releaseDate: String
    ) = Favorite(mediaId, mediaType, image, favorite, rating, title, releaseDate)
}