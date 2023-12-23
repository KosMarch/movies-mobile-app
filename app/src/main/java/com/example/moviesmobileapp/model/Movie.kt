package com.example.moviesmobileapp.model

import java.time.LocalDate

data class Movie(
    val id: Int,
    val title: String,
    val description: String,
    val rating: Double,
    val duration: String,
    val genre: List<String>,
    val releaseDate: LocalDate,
    val trailerLink: String,
    val imageResourceId: Int,
    var inWatchlist: Boolean
)
