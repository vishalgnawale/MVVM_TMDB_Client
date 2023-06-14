package com.example.tmdbclient.data.repository.artist.datasourceimpl

import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.modal.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCachedDataSource

class ArtistCachedDataSourceImpl:ArtistCachedDataSource {
    private var artists=ArrayList<Artist>()
    override suspend fun getArtistCachedData(): List<Artist> {
        return artists
    }

    override suspend fun saveArtistToCached(artistList: List<Artist>) {
        artists=ArrayList(artistList)
    }
}