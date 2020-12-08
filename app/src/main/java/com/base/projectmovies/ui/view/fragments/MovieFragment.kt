package com.base.projectmovies.ui.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.observe
import androidx.navigation.navGraphViewModels
import com.base.projectmovies.BR
import com.base.projectmovies.R
import com.base.projectmovies.ui.view.adapters.MovieAdapter
import com.base.projectmovies.base.BaseFragment
import com.base.projectmovies.databinding.FragmentMovieBinding
import com.base.projectmovies.extensions.autoCleared
import com.base.projectmovies.ui.viewmodel.MovieVM
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.android.synthetic.main.fragment_movie.*


@AndroidEntryPoint
class MovieFragment : BaseFragment() {


    private val vm by navGraphViewModels<MovieVM>(R.id.nav_graph) {
        defaultViewModelProviderFactory
    }
    private var binding by autoCleared<FragmentMovieBinding>()
    private var adapter = MutableLiveData<MovieAdapter>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentMovieBinding>(
            inflater,
            R.layout.fragment_movie,
            container,
            false
        ).also {
            binding = it
        }.root

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.setVariable(BR.vm,vm)
        initRecyclerView(binding.rvMovie)

        vm.list.observe(viewLifecycleOwner) {
            adapter.value = MovieAdapter(vm.list.value!!, parentFragment)
            adapter.value!!.updateData(it)
            binding.rvMovie.adapter = adapter.value
            adapter.value?.notifyDataSetChanged()

        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        rv_movie.adapter = null
        adapter.value = null
        vm.clear()
    }
}