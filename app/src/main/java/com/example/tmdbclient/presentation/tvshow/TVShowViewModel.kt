package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedTVShowUseCase

class TVShowViewModel(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val getUpdatedTVShowUseCase: GetUpdatedTVShowUseCase
    ) :ViewModel(){
    fun getTvShows()= liveData {
        val tvShowList=getTVShowUseCase.getTVShow()
        emit(tvShowList)
    }

    fun getUpdatedTvShows()= liveData {
        val tvShowList=getUpdatedTVShowUseCase.updatedTVShows()
        emit(tvShowList)
    }
}