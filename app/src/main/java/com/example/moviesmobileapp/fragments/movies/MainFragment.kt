package com.example.moviesmobileapp.fragments.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmobileapp.R
import com.example.moviesmobileapp.adapters.MovieAdapter
import com.example.moviesmobileapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rcVMovies.layoutManager = LinearLayoutManager(requireContext())

        val adapter = MovieAdapter(viewModel.movieList.value) { id ->
            val bundle = Bundle()
            bundle.putInt("movieId", id)
            Navigation.findNavController(view)
                .navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        }

        binding.btSort.setOnClickListener {
            showPopupMenu(it)
        }

        binding.rcVMovies.adapter = adapter

        viewModel.movieList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(requireContext(), view)
        popupMenu.menuInflater.inflate(R.menu.sort_menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.bt_sort_name -> {
                    viewModel.sortByTitle()
                    true
                }

                R.id.bt_sort_date -> {
                    viewModel.sortByDate()
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }
}
