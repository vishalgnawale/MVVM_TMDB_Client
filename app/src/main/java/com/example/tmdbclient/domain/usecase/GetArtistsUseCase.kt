package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.domain.repository.ArtistsRepository

class GetArtistsUseCase (private val artistsRepository: ArtistsRepository){
    suspend fun getArtists():List<Artist>?=artistsRepository.getArtists()
}