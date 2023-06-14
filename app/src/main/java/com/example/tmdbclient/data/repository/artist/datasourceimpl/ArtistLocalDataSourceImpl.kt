package com.example.tmdbclient.data.repository.artist.datasourceimpl

import com.example.tmdbclient.data.db.ArtistDao
import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao:ArtistDao):ArtistLocalDataSource {
    override suspend fun getAllArtistFromDb(): List<Artist> {
        return artistDao.getAllArtist()
    }

    override suspend fun saveAllArtistDb(artistList: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveAllArtist(artistList)
        }
    }

    override suspend fun clearAllData() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}