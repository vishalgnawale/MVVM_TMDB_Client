package com.example.tmdbclient.domain.usecase

import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.domain.repository.ArtistsRepository

class GetUpdatedArtistsUseCase(private val artistsRepository: ArtistsRepository) {
    suspend fun updatedArtists():List<Artist>?=artistsRepository.updatedArtists()
}