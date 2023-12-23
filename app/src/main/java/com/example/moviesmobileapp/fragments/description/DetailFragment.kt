package com.example.moviesmobileapp.fragments.description

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.example.moviesmobileapp.R
import com.example.moviesmobileapp.databinding.FragmentDetailBinding
import com.example.moviesmobileapp.model.Movie
import java.time.format.DateTimeFormatter

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by activityViewModels()
    private var movie: Movie? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btDetailBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_detailFragment_to_mainFragment)
        }

        arguments?.getInt("movieId")?.let { viewModel.setId(it) }

        movie = viewModel.movie.value

        binding.btDetailWatchlist.setOnCheckedChangeListener { _, isChecked ->
            viewModel.changeOnWatchList(isChecked)
        }

        viewModel.movie.observe(viewLifecycleOwner) {
            binding.btDetailWatchlist.isChecked = it.inWatchlist
        }

        Glide.with(view)
            .load(viewModel.movie.value?.imageResourceId)
            .into(binding.imDetailPoster)

        binding.btDetailTrailer.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(viewModel.movie.value?.trailerLink))
            startActivity(intent)
        }

        binding.tvDetailTitle.text = movie?.title
        binding.tvDetailRating.text = movie?.rating.toString()
        binding.tvDetailDescription.text = movie?.description
        binding.tvDetailGenre.text = movie?.genre?.joinToString()
        binding.tvDetailDate.text =
            movie?.releaseDate?.format(DateTimeFormatter.ofPattern("yyyy d MMMM"))
    }
}
