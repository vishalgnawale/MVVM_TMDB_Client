package com.example.tmdbclient.domain.repository

import com.example.tmdbclient.data.modal.artist.Artist

interface ArtistsRepository {
    suspend fun getArtists():List<Artist>
    suspend fun updatedArtists():List<Artist>
}