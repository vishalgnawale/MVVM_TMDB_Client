package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedTVShowUseCase
import com.example.tmdbclient.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTVShowUseCase: GetTVShowUseCase,
        getUpdatedTVShowUseCase: GetUpdatedTVShowUseCase
    ):TVShowViewModelFactory{
        return TVShowViewModelFactory(getTVShowUseCase,getUpdatedTVShowUseCase)
    }
}