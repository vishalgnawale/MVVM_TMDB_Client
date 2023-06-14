package com.example.tmdbclient.data.db

import androidx.room.*
import com.example.tmdbclient.data.modal.tvshow.TVShow

@Dao
interface TVShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTVShows(tvshows:List<TVShow>)

    @Query("DELETE from popular_tvshows")
    suspend fun deleteAllTVShows()

    @Query("SELECT * from popular_tvshows")
    suspend fun getAllTVShows():List<TVShow>

}