package com.uhc.presentation.home

import android.os.Bundle
import android.view.View
import com.uhc.presentation.R
import com.uhc.presentation.databinding.HomeFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Constancio on 2019-05-18.
 */
class HomeFragment : BaseFragment<HomeFragmentBinding>() {
    val viewModel: HomeViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.home_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

    }
}