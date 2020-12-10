package com.base.projectmovies.ui.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.base.projectmovies.api.NetworkApi
import com.base.projectmovies.batmanlist.MovieListModel

import com.base.projectmovies.extensions.default
import com.base.projectmovies.remote.responce.batmanlist.SearchModel


import kotlinx.coroutines.launch


class MovieVM @ViewModelInject constructor(
    private val networkApi: NetworkApi,

) : ViewModel() {


    var list = MutableLiveData<MutableList<SearchModel>>().default(mutableListOf())
    var loading = MutableLiveData<Boolean>().default(false)
    var retry = MutableLiveData<Boolean>().default(false)


    init {
        getList()
    }


    fun getList() {
        loading.value = true
        retry.value = false
        if (list.value.isNullOrEmpty()) {
            viewModelScope.launch {
                try {
                    val response = networkApi.GetList()
                    handleList(response, response.Search)
                } catch (t: Throwable) {

                    handleError(t)
                }
            }
        }
    }


    fun retry() {
        getList()
    }


    private fun handleList(baseResponse: MovieListModel, response: MutableList<SearchModel>) {
        if (baseResponse.responses != "False") {
            try {
                list.value?.addAll(response)
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