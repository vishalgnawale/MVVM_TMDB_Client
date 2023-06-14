package com.example.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context):TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbdatabase").build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmbdDatabase: TMDBDatabase):MovieDao{
        return tmbdDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao(tmbdDatabase: TMDBDatabase):ArtistDao{
        return tmbdDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTVShowDao(tmbdDatabase: TMDBDatabase):TVShowDao{
        return tmbdDatabase.tvShowDao()
    }
}