package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.modal.artist.ArtistList

interface ArtistCachedDataSource {
    suspend fun getArtistCachedData():List<Artist>
    suspend fun saveArtistToCached(artistList: List<Artist>)
}