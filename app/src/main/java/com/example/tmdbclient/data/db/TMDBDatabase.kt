package com.example.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.modal.tvshow.TVShow

@Database(entities =[Movie::class,TVShow::class,Artist::class]
, version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TVShowDao
    abstract fun artistDao(): ArtistDao

}