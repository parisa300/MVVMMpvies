package com.base.projectmovies.ui.view.activities

import android.os.Bundle
import com.base.projectmovies.R
import com.base.projectmovies.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MovieActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }



}