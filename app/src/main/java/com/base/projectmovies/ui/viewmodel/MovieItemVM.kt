package com.base.projectmovies.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.base.projectmovies.remote.responce.batmanlist.SearchModel


class MovieItemVM constructor(
    val movieListModel: SearchModel?
) : ViewModel()