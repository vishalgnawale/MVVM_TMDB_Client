package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.BuildConfig
import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideMovieDataSource(tmbdService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmbdService,BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun provideTVDataSource(tmbdService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmbdService,BuildConfig.API_KEY)
    }

    @Singleton
    @Provides
    fun provideArtistDataSource(tmbdService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmbdService,BuildConfig.API_KEY)
    }
}