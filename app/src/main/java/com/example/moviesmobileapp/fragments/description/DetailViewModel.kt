package com.example.moviesmobileapp.fragments.description

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesmobileapp.model.Movie
import com.example.moviesmobileapp.repository.MovieRepository

class DetailViewModel : ViewModel() {
    private val repository = MovieRepository()
    private val _movie = MutableLiveData<Movie>()
    private var _id: Int = -1
    val movie: LiveData<Movie> = _movie

    fun changeOnWatchList(value: Boolean) {
        _movie.value?.inWatchlist = value
        val newMovie = repository.findById(_id)
        newMovie?.inWatchlist = value
        if (newMovie != null) {
            repository.updateMovie(newMovie)
        }
    }

    fun setId(id: Int) {
        _id = id
        _movie.value = repository.findById(id)
    }
}
