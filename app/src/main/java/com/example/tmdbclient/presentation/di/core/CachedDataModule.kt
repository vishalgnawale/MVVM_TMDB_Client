package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.repository.artist.datasource.ArtistCachedDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistCachedDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieCachedDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieCachedDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCachedDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowCachedDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CachedDataModule {
    @Singleton
    @Provides
    fun provideMovieCachedDataSource():MovieCachedDataSource{
        return MovieCachedDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCachedDataSource():TvShowCachedDataSource{
        return TvShowCachedDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCachedDataSource():ArtistCachedDataSource{
        return ArtistCachedDataSourceImpl()
    }
}