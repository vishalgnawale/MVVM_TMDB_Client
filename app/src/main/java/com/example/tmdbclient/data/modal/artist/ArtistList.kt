package com.example.tmdbclient.data.modal.artist


import com.example.tmdbclient.data.modal.artist.Artist
import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Artist>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)