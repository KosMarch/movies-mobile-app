package com.example.moviesmobileapp.data

import android.annotation.SuppressLint
import com.example.moviesmobileapp.R
import com.example.moviesmobileapp.model.Movie
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Resources {
    @SuppressLint("SimpleDateFormat")
    private val _movieList: MutableList<Movie> = mutableListOf(
        Movie(
            0,
            "Tenet",
            "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.",
            7.8,
            "2h 30 min",
            listOf("Action", "Sci-Fi"),
            LocalDate.parse("3 September 2020", DateTimeFormatter.ofPattern("d MMMM yyyy")),
            "https://www.youtube.com/watch?v=LdOM0x0XDMo",
            R.drawable.im_tenet,
            false
        ),
        Movie(
            1,
            "Spider-Man: Into the Spider-Verse",
            "Teen Miles Morales becomes the Spider-Man of his universe, and must join with five spider-powered individuals from other dimensions to stop a threat for all realities. ",
            8.4,
            "1h 57min",
            listOf("Action", "Animation", "Adventure"),
            LocalDate.parse("14 December 2018", DateTimeFormatter.ofPattern("d MMMM yyyy")),
            "https://www.youtube.com/watch?v=tg52up16eq0",
            R.drawable.im_spider_man,
            true
        ),
        Movie(
            2,
            "Knives Out",
            "A detective investigates the death of a patriarch of an eccentric, combative family",
            7.9,
            "2h 10min",
            listOf("Comedy", "Crime", "Drama"),
            LocalDate.parse("27 November 2019", DateTimeFormatter.ofPattern("d MMMM yyyy")),
            "https://www.youtube.com/watch?v=qGqiHJTsRkQ",
            R.drawable.im_knives_out,
            false
        ),
        Movie(
            3,
            "Guardians of the Galaxy",
            "A group of intergalactic criminals must pull together to stop a fanatical warrior with plans to purge the universe.",
            8.0,
            "2h 1min",
            listOf("Action", "Adventure", "Comedy"),
            LocalDate.parse("1 August 2014", DateTimeFormatter.ofPattern("d MMMM yyyy")),
            "https://www.youtube.com/watch?v=d96cjJhvlMA ",
            R.drawable.im_guardians_of_the_galaxy,
            true
        ),
        Movie(
            4,
            "Avengers: Age of Ultron",
            "When Tony Stark and Bruce Banner try to jump-start a dormant peacekeeping program called Ultron, things go horribly wrong and it's up to Earth's mightiest heroes to stop the villainous Ultron from enacting his terrible plan.",
            7.3,
            "2h 21min",
            listOf("Action", "Adventure", "Sci-Fi"),
            LocalDate.parse("1 May 2015", DateTimeFormatter.ofPattern("d MMMM yyyy")),
            "https://www.youtube.com/watch?v=tmeOjFno6Do ",
            R.drawable.im_avengers,
            false

        )
    )

    val movieList = _movieList

    fun findById(id: Int): Movie? {
        return movieList.find { movie -> movie.id == id }
    }

    fun update(newMovie: Movie) {
        val index = _movieList.indexOfFirst { it.id == newMovie.id }
        if (index != -1) _movieList[index] = newMovie
    }
}
