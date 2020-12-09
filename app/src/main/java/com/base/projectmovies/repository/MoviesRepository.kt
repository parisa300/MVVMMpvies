package com.base.projectmovies.repository

import com.base.projectmovies.batmanlist.SearchModel
import com.base.projectmovies.db.MovieDatabase


class MoviesRepository(
    val db:MovieDatabase
) {

    suspend fun upsert(movie:SearchModel) =db.getMovieDao().upsert(movie)
    fun getSavedMovies()=db.getMovieDao().getAllMovie()


}