package com.example.tmdbclient.presentation.di.movie

import com.example.tmdbclient.domain.usecase.GetMoviesUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedMovieUseCase
import com.example.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
@InstallIn(ActivityComponent::class)
@Module
class MovieModule {

    @ActivityScoped
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        getUpdatedMovieUseCase: GetUpdatedMovieUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase,getUpdatedMovieUseCase)
    }
}