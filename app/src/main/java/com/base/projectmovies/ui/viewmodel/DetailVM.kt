package com.base.projectmovies.ui.viewmodel


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.projectmovies.api.NetworkApi
import com.base.projectmovies.batmanlist.SearchModel
import com.base.projectmovies.const.ApiConstants
import com.base.projectmovies.detail.DetailListModel
import com.base.projectmovies.extensions.default
import com.base.projectmovies.repository.MoviesRepository
import kotlinx.coroutines.launch


class DetailVM @ViewModelInject constructor(
    private val networkApi: NetworkApi,
    val moviesRepository: MoviesRepository
    ) : ViewModel() {

    var title = MutableLiveData<String>().default("")
    var year = MutableLiveData<String>().default("")
    var rated = MutableLiveData<String>().default("")
    var released = MutableLiveData<String>().default("")
    var runtime = MutableLiveData<String>().default("")
    var genre = MutableLiveData<String>().default("")
    var director = MutableLiveData<String>().default("")
    var rating = MutableLiveData<String>().default("")
    var writer = MutableLiveData<String>().default("")
    var actors = MutableLiveData<String>().default("")
    var plot = MutableLiveData<String>().default("")
    var poster = MutableLiveData<String>().default("")
    var loading = MutableLiveData<Boolean>().default(false)
    var retry = MutableLiveData<Boolean>().default(false)
    var imdbID = MutableLiveData<String>()

    fun getImdbID(id: String) {
        imdbID.value = id
    }

    fun getDetail() {
        loading.value = true
        retry.value = false

        viewModelScope.launch {
            try {
                val response =
                    networkApi.GetDetail(imdbID = ApiConstants.DetailMovie + imdbID.value)
                handleDetail(response)
            } catch (t: Throwable) {

                handleError(t)
            }
        }
    }


    fun retry() {
        getDetail()
    }
    fun saveMovie(article: SearchModel) =viewModelScope.launch {
        moviesRepository.upsert(article)
    }

    fun getSavedMovies()=moviesRepository.getSavedMovies()

    private fun handleDetail(response: DetailListModel) {
        if (response.responses != "False") {
            try {
                title.value = "Title: ".plus(response.Title)
                year.value = "Year: ".plus(response.Year)
                rated.value = "Rated: ".plus(response.Rated)
                released.value = "Released: ".plus(response.Released)
                runtime.value = "Runtime: ".plus(response.Runtime)
                genre.value = "Genre: ".plus(response.Genre)
                director.value = "Director: ".plus(response.Director)
                rating.value = response.imdbRating
                writer.value = "Wirters: ".plus(response.Writer)
                actors.value = "Actors: ".plus(response.Actors)
                plot.value = "Plot: ".plus(response.Plot)
                poster.value = response.Poster
                loading.value = false
            } catch (e: Exception) {

                retry.value = true
                loading.value = false
            }
        } else {

            retry.value = true
            loading.value = false
        }

    }

    private fun handleError(t: Throwable) {

        loading.value = false
        retry.value = true
    }

    fun clear() = onCleared()

    override fun onCleared() {

    }

}