package com.example.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tmdbclient.domain.usecase.GetTVShowUseCase
import com.example.tmdbclient.domain.usecase.GetUpdatedTVShowUseCase

class TVShowViewModelFactory(
    private val getTVShowUseCase: GetTVShowUseCase,
    private val getUpdatedTVShowUseCase: GetUpdatedTVShowUseCase
) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TVShowViewModel(getTVShowUseCase,getUpdatedTVShowUseCase) as T
    }
}