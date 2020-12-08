package com.base.projectmovies

import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp



@HiltAndroidApp()
class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
      //  KitLog.init()
        MultiDex.install(this)
    }



}