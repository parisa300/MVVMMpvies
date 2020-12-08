package com.base.projectmovies.api


import com.base.projectmovies.batmanlist.MovieListModel
import com.base.projectmovies.const.ApiConstants
import com.base.projectmovies.detail.DetailListModel
import retrofit2.http.GET
import retrofit2.http.Url

interface NetworkApi {


    @GET
    suspend fun GetList(
        @Url suffix: String = ApiConstants.LISTMOVIE
    ): MovieListModel


    @GET
    suspend fun GetDetail(
        @Url imdbID: String
    ): DetailListModel

}