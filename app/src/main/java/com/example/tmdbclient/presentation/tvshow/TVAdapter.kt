package com.example.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.tmdbclient.R
import com.example.tmdbclient.data.modal.movie.Movie
import com.example.tmdbclient.data.modal.tvshow.TVShow
import com.example.tmdbclient.databinding.ListItemBinding

class TVAdapter : RecyclerView.Adapter<TVAdapter.TVShowViewHolder>() {

    private val tvShowList=ArrayList<TVShow>()

    fun setList(tvshows:List<TVShow>){
        tvShowList.clear()
        tvShowList.addAll(tvshows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowViewHolder {
         val layoutInflater:LayoutInflater =LayoutInflater.from(parent.context)
        val binding : ListItemBinding=DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return TVShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVShowViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }


    class TVShowViewHolder(private val binding :ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(tvShow: TVShow){
            binding.titleTextView.text=tvShow.name
            binding.descriptionTextView.text=tvShow.overview
            val posterURL = "https://image.tmdb.org/t/p/w500"+tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterURL)
                .into(binding.imageView)

        }
    }
}