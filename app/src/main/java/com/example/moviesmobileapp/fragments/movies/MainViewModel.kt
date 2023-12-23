package com.example.moviesmobileapp.fragments.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesmobileapp.model.Movie
import com.example.moviesmobileapp.repository.MovieRepository

class MainViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movieList = MutableLiveData<List<Movie>>()
    val movieList: LiveData<List<Movie>> = _movieList

    init {
        _movieList.value = repository.getMovies()
    }

    fun sortByTitle() {
        _movieList.value = _movieList.value?.sortedBy { it.title }
    }

    fun sortByDate() {
        _movieList.value = _movieList.value?.sortedBy { it.releaseDate }
    }
}
