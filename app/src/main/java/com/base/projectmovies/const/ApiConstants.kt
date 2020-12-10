package com.base.projectmovies.const

import com.base.projectmovies.locals.FavoriteMovieDatabase
import dagger.Provides
import javax.inject.Singleton

object ApiConstants {

    var BASE_URL = "http://www.omdbapi.com"
    var LISTMOVIE = "/?apikey=3e974fca&s=batman"
    var DetailMovie = "/?apikey=3e974fca&i="
}
