package com.example.tmdbclient.data.repository.tvshow

import android.util.Log
import com.example.tmdbclient.data.modal.tvshow.TVShow
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowCachedDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.TVShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCachedDataSource: TvShowCachedDataSource
) :TVShowRepository {
    override suspend fun getTVShow(): List<TVShow> {
        return getTvShowsFromCached()
    }

    override suspend fun updatedTVShows(): List<TVShow> {
        val tvShowsList=getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvshows(tvShowsList)
        tvShowCachedDataSource.saveCachedTvShows(tvShowsList)
        return tvShowsList
    }
    private suspend fun getTvShowsFromApi():List<TVShow>{
        lateinit var tvShows:List<TVShow>
        try {
            val response=tvShowRemoteDataSource.getTvShows()
            val body=response.body()
            if(body!=null){
                tvShows=body.results
            }
        }catch (e:Exception){
            Log.d("TMDB", "getTvShowsFromApi: ${e.message.toString()}")
        }
        return tvShows
    }

    private suspend fun getTvShowsFromDatabase():List<TVShow>{
        lateinit var tvShows:List<TVShow>
        try {
            tvShows=tvShowLocalDataSource.getTvShowsFromDb()
        }catch (e:Exception){
            Log.d("TMDB", "getTvShowsFromApi: ${e.message.toString()}")
        }
        if(tvShows.size>0){
            return tvShows
        }else{
            tvShows=getTvShowsFromApi()
            tvShowLocalDataSource.saveTvshows(tvShows)
            return tvShows
        }
    }

    private suspend fun getTvShowsFromCached():List<TVShow>{
        lateinit var tvShows:List<TVShow>
        try {
            tvShows=tvShowCachedDataSource.getCachedTvShows()
        }catch (e:Exception){
            Log.d("TMDB", "getTvShowsFromApi: ${e.message.toString()}")
        }
        if(tvShows.size>0){
            return tvShows
        }else{
            tvShows=getTvShowsFromDatabase()
            tvShowCachedDataSource.saveCachedTvShows(tvShows)
            return tvShows
        }
    }
}