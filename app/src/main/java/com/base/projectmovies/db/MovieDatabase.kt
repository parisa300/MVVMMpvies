package com.base.projectmovies.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class MovieDatabase :RoomDatabase() {

 abstract fun getMovieDao():MovieDao

 companion object{
  @Volatile
  private var instance :MovieDatabase?=null
  private val LOCK=Any()

  operator fun invoke(context: Context)= instance?: synchronized(LOCK){

   instance?:createDatabase(context).also{ instance=it }


  }


  private fun createDatabase(context: Context)=
   Room.databaseBuilder(
    context.applicationContext,
    MovieDatabase::class.java,
    "Movie.db"
   ).build()
 }
}