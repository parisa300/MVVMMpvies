package com.base.projectmovies.module

import com.base.projectmovies.api.NetworkApi
import com.base.projectmovies.const.ApiConstants
import com.base.projectmovies.locals.FavoriteMovieDatabase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module(includes = [OkHttpClientModule::class])
@InstallIn(ApplicationComponent::class)
class NetworkModule {

    private lateinit var api: NetworkApi

    @Provides
    @Singleton
    fun networkApi(retrofit: Retrofit): NetworkApi {
        api = retrofit.create(NetworkApi::class.java)
        return retrofit.create(NetworkApi::class.java)
    }

    @Provides
    @Singleton
    fun retrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

}


