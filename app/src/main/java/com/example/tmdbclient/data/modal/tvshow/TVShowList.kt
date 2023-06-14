package com.example.tmdbclient.data.modal.tvshow


import com.example.tmdbclient.data.modal.tvshow.TVShow
import com.google.gson.annotations.SerializedName

data class TVShowList(
    @SerializedName("results")
    val results: List<TVShow>,

    )