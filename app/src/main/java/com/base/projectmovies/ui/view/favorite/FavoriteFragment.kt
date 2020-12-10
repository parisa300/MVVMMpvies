package com.base.projectmovies.ui.view.favorite

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.base.projectmovies.R
import com.base.projectmovies.databinding.FragmentSaveMovieBinding
import com.base.projectmovies.remote.responce.batmanlist.SearchModel
import com.base.projectmovies.ui.viewmodel.FavoriteViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_save_movie){
    private val viewModel by viewModels<FavoriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSaveMovieBinding.bind(view)

        val adapter = FavoriteAdapter()

        viewModel.movies.observe(viewLifecycleOwner){
            adapter.setMovieList(it)
            binding.apply {
                rvSaveDetail.setHasFixedSize(true)
                rvSaveDetail.adapter = adapter
            }
        }


        adapter.setOnItemClickCallback(object : FavoriteAdapter.OnItemClickCallback{
            override fun onItemClick(favoriteMovie: SearchModel) {
                val movie = SearchModel(
                    favoriteMovie.id,
                    favoriteMovie.title,
                    favoriteMovie.poster,
                    favoriteMovie.year
                )

               findNavController().navigate(R.id.action_movieFragment_to_DetailFragment).apply {
                   movie
               }

            }

        })
    }
}