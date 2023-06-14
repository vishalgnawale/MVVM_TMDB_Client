package com.example.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdbclient.data.modal.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllArtist(artist:List<Artist>)

    @Query("DELETE from popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * from popular_artists")
    suspend fun getAllArtist():List<Artist>
}