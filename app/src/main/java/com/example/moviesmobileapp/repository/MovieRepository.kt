package com.example.moviesmobileapp.repository

import com.example.moviesmobileapp.data.Resources
import com.example.moviesmobileapp.model.Movie

class MovieRepository {
    fun getMovies(): List<Movie> {
        return Resources.movieList
    }

    fun findById(id: Int): Movie? {
        return Resources.findById(id)
    }

    fun updateMovie(newMovie: Movie) {
        Resources.update(newMovie)
    }
 }
