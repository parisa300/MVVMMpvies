package com.base.projectmovies.locals

import androidx.room.Database
import androidx.room.RoomDatabase

import com.base.projectmovies.remote.responce.batmanlist.SearchModel

@Database(
    entities = [SearchModel::class],
    version = 1
)
abstract class FavoriteMovieDatabase : RoomDatabase(){
    abstract fun getFavoriteMovieDao(): FavoriteMovieDao
}