package com.base.projectmovies.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.base.projectmovies.ui.viewmodel.MovieVM


class MoviesViewModelProviderFactory (
    val moviesRepository: MoviesRepository
):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieVM(moviesRepository) as T
    }
}