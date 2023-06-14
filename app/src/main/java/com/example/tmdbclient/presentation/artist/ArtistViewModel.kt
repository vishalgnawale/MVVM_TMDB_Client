package com.example.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetArtistsUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val getUpdatedArtistsUseCase: GetUpdatedArtistsUseCase
): ViewModel() {
    fun getArtists()= liveData {
        val artistList=getArtistsUseCase.getArtists()
        emit(artistList)
    }

    fun getUpdatedArtist()= liveData {
        val artistList=getUpdatedArtistsUseCase.updatedArtists()
        emit(artistList)
    }
}