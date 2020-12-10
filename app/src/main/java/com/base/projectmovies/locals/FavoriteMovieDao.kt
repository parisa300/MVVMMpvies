package com.base.projectmovies.locals

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.base.projectmovies.remote.responce.batmanlist.SearchModel
import dagger.Provides

@Dao
interface FavoriteMovieDao {
    @Insert

    suspend fun addToFavorite(favoriteMovie: SearchModel)

    @Query("SELECT * FROM movies")
    fun getFavoriteMovie(): LiveData<List<SearchModel>>

    @Query("SELECT count(*) FROM movies WHERE movies.imdbID = :id")
    suspend fun checkMovie(id: String): Int

    @Query("DELETE FROM movies WHERE movies.imdbID = :id" )
    suspend fun removeFromFavorite(id: String) : Int
}