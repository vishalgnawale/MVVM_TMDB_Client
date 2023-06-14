package com.example.tmdbclient.presentation.di.artist

import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedArtistsUseCase
import com.example.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule() {

    @ArtistScope
    @Provides
    fun artistViewModelFactory(
         getArtistsUseCase: GetArtistsUseCase,
         getUpdatedArtistsUseCase: GetUpdatedArtistsUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistsUseCase,getUpdatedArtistsUseCase)
    }

}