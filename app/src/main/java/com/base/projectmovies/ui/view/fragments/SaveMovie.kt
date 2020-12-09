package com.base.projectmovies.ui.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.navigation.navGraphViewModels
import com.base.projectmovies.BR
import com.base.projectmovies.R
import com.base.projectmovies.base.BaseFragment
import com.base.projectmovies.databinding.FragmentDetailBinding
import com.base.projectmovies.databinding.FragmentMovieBinding
import com.base.projectmovies.databinding.FragmentSaveMovieBinding
import com.base.projectmovies.extensions.autoCleared
import com.base.projectmovies.ui.view.adapters.MovieAdapter
import com.base.projectmovies.ui.viewmodel.DetailVM
import com.base.projectmovies.ui.viewmodel.MovieVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_save_movie.*

@AndroidEntryPoint
class SaveMovie :  BaseFragment() {

    private val vm by navGraphViewModels<DetailVM>(R.id.nav_graph) {
        defaultViewModelProviderFactory
    }
    private var binding by autoCleared<FragmentSaveMovieBinding>()
    private var adapter = MutableLiveData<MovieAdapter>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentSaveMovieBinding>(
            inflater,
            R.layout.fragment_save_movie,
            container,
            false
        ).also {
            binding = it
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.vm,vm)
        initRecyclerView(binding.rvSaveDetail)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        rv_saveDetail.adapter = null
        adapter.value = null
        vm.clear()
    }
}