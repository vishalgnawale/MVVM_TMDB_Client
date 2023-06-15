package com.example.tmdbclient.presentation.di.core

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.db.MovieDao
import com.example.tmdbclient.data.db.TMDBDatabase
import com.example.tmdbclient.data.db.TVShowDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideMovieDatabase(app:Application):TMDBDatabase{
        return Room.databaseBuilder(app,TMDBDatabase::class.java,"tmdbdatabase").build()
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