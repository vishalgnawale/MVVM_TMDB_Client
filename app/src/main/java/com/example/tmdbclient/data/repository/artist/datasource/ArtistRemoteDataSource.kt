package com.example.tmdbclient.data.repository.artist.datasource

import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.modal.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtistList(): Response<ArtistList>
}