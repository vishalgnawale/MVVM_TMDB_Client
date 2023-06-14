package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.api.TMDBService
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.repository.artist.datasourceimpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.repository.movie.datasourceimpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.repository.tvshow.datasourceimpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {
    @Singleton
    @Provides
    fun provideMovieDataSource(tmbdService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(tmbdService,apiKey)
    }

    @Singleton
    @Provides
    fun provideTVDataSource(tmbdService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(tmbdService,apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistDataSource(tmbdService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteDataSourceImpl(tmbdService,apiKey)
    }
}