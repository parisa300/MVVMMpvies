package com.base.projectmovies.ui.view.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.DataBindingUtil
import androidx.navigation.navGraphViewModels
import com.base.projectmovies.BR
import com.base.projectmovies.R
import com.base.projectmovies.base.BaseFragment
import com.base.projectmovies.databinding.FragmentDetailBinding

import com.base.projectmovies.extensions.autoCleared
import com.base.projectmovies.ui.viewmodel.DetailVM
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class DetailFragment() : BaseFragment() {

    private val vm by navGraphViewModels<DetailVM>(R.id.nav_graph) {
        defaultViewModelProviderFactory
    }
    private var binding by autoCleared<FragmentDetailBinding>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        ).also {
            binding = it
        }.root

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lifecycleOwner = viewLifecycleOwner

       binding.setVariable(BR.vm,vm)
        arguments?.let {
            vm.getImdbID(it.getString("imdbID")!!)
        }
        vm.getDetail()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        vm.clear()
    }
}
