package com.example.tmdbclient.presentation.di.tvshow

import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedTVShowUseCase
import com.example.tmdbclient.presentation.tvshow.TVShowViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@InstallIn(ActivityComponent::class)
@Module
class TvShowModule {

    @ActivityScoped
    @Provides
    fun provideTvShowViewModelFactory(
        getTVShowUseCase: GetTVShowUseCase,
        getUpdatedTVShowUseCase: GetUpdatedTVShowUseCase
    ):TVShowViewModelFactory{
        return TVShowViewModelFactory(getTVShowUseCase,getUpdatedTVShowUseCase)
    }
}