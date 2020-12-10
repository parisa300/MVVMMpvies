package com.base.projectmovies.base

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class BaseFragment : Fragment() {

    var hasInitializedRootView = false
    private var rootView: View? = null

    fun getPersistentView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
        layout: Int
    ): View? {
        if (rootView == null) {
            // Inflate the layout for this fragment
            rootView = inflater?.inflate(layout, container, false)
        } else {

            (rootView?.parent as? ViewGroup)?.removeView(rootView)
        }

        return rootView
    }
    fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
    //    recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = GridLayoutManager(context, 1)
    }
}