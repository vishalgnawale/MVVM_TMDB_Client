package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.modal.artist.ArtistList

interface ArtistLocalDataSource {
    suspend fun getAllArtistFromDb():List<Artist>
    suspend fun saveAllArtistDb(artistList: List<Artist>)
    suspend fun clearAllData()
}