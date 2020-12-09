package com.base.projectmovies.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.base.projectmovies.batmanlist.SearchModel
import com.base.projectmovies.detail.DetailListModel

interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(movie: SearchModel):Long

    @Delete
    suspend fun deleteMovie(movie: DetailListModel)

    @Query("SELECT * FROM movies")
    fun getAllMovie(): LiveData<List<SearchModel>>
}