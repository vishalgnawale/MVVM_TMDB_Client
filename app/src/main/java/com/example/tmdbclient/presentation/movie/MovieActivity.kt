package com.example.tmdbclient.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbclient.R
import com.example.tmdbclient.databinding.ActivityMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    private lateinit var adapter:MovieAdapter
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_movie)
        movieViewModel=ViewModelProvider(this,factory).get(MovieViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.movieProgressBar.visibility=View.VISIBLE
        binding.movieRecyclerView.layoutManager=LinearLayoutManager(this)
        adapter=MovieAdapter()
        binding.movieRecyclerView.adapter=adapter
        displayPopularMovie()
    }

    private fun displayPopularMovie(){
        val responseLiveData=movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility=View.GONE
            }else{
                binding.movieProgressBar.visibility=View.GONE
                Toast.makeText(this,"No Data Available",Toast.LENGTH_LONG).show()
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater =menuInflater
        inflater.inflate(R.menu.update_menu,menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.action_update->{
                updateMovies()
                return true
            }else
                ->return super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility=View.VISIBLE
        val responseLivedata=movieViewModel.updatedMovieList()
        responseLivedata.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility=View.GONE
            }else{
                binding.movieProgressBar.visibility=View.GONE
                Toast.makeText(this,"No Updated Movie Available",Toast.LENGTH_LONG).show()
            }
        })
    }
}