package com.example.moviesmobileapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesmobileapp.R
import com.example.moviesmobileapp.databinding.MovieItemBinding
import com.example.moviesmobileapp.model.Movie
import java.time.format.DateTimeFormatter

class MovieAdapter(
    private var movieList: List<Movie>?,
    private val listener: Listener
) : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(Comparator()) {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val movieImageView: ImageView = itemView.findViewById(R.id.im_item_poster)
        private val binding = MovieItemBinding.bind(itemView)

        @SuppressLint("SetTextI18n")
        fun loadMovie(item: Movie) {
            binding.tvFilmName.text =
                "${item.title} (${item.releaseDate.format(DateTimeFormatter.ofPattern("yyyy"))})"
            binding.tvTimeGenre.text = "${item.duration} - ${item.genre.joinToString()}"
            binding.tvWatchList.text = if (item.inWatchlist) "ON MY WATCHLIST" else ""

            Glide.with(itemView)
                .load(item.imageResourceId)
                .into(movieImageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieModel = movieList?.getOrNull(position)

        if (movieModel != null) {
            holder.loadMovie(movieModel)
            holder.itemView.setOnClickListener {
                listener.onClick(movieModel.id)
            }
        }
    }

    class Comparator : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
