package com.example.tmdbclient.data.repository.artist

import android.util.Log
import com.example.tmdbclient.data.modal.artist.Artist
import com.example.tmdbclient.data.modal.artist.ArtistList
import com.example.tmdbclient.data.repository.artist.datasource.ArtistCachedDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistsRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCachedDataSource: ArtistCachedDataSource
):ArtistsRepository{
    override suspend fun getArtists(): List<Artist> {
        return getArtistFromCached()
    }

    override suspend fun updatedArtists(): List<Artist> {
        artistLocalDataSource.clearAllData()
        val artistList=getArtistFromApi()
        artistLocalDataSource.saveAllArtistDb(artistList)
        artistCachedDataSource.saveArtistToCached(artistList)
        return artistList
    }

    private suspend fun getArtistFromApi():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            val response=artistRemoteDataSource.getArtistList()
            val body=response.body()
            if(body!=null){
                artistList=body.results
            }
        }catch (e:Exception){
            Log.d("TMDB", "getArtistFromApi: ${e.message.toString()}")
        }
        return artistList
    }

    private suspend fun getArtistFromDatabase():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList=artistLocalDataSource.getAllArtistFromDb()
        }catch (e:Exception){
            Log.d("TMDB", "getArtistFromApi: ${e.message.toString()}")
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistFromApi()
            artistLocalDataSource.saveAllArtistDb(artistList)
            return artistList
        }
    }

    private suspend fun getArtistFromCached():List<Artist>{
        lateinit var artistList:List<Artist>
        try {
            artistList=artistCachedDataSource.getArtistCachedData()
        }catch (e:Exception){
            Log.d("TMDB", "getArtistFromApi: ${e.message.toString()}")
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList=getArtistFromDatabase()
            artistCachedDataSource.saveArtistToCached(artistList)
            return artistList
        }
    }
}