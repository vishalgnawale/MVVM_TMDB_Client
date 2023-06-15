package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.domain.repository.ArtistsRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TVShowRepository
import com.example.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Provides
    fun provideMovieUseCase(movieRepository: MovieRepository):GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }


    @Provides
    fun provideTvShowUseCase(tvShowRepository: TVShowRepository):GetTVShowUseCase{
        return GetTVShowUseCase(tvShowRepository)
    }


    @Provides
    fun provideArtistUseCase(artistsRepository: ArtistsRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistsRepository)
    }


    @Provides
    fun provideUpdatedMovieUseCase(movieRepository: MovieRepository):GetUpdatedMovieUseCase{
        return GetUpdatedMovieUseCase(movieRepository)
    }

    @Provides
    fun provideUpdatedTvShowUseCase(tvShowRepository: TVShowRepository):GetUpdatedTVShowUseCase{
        return GetUpdatedTVShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdatedArtistUseCase(artistsRepository: ArtistsRepository):GetUpdatedArtistsUseCase{
        return GetUpdatedArtistsUseCase(artistsRepository)
    }
}