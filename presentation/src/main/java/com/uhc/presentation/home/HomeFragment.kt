package com.uhc.presentation.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.uhc.presentation.R
import com.uhc.presentation.databinding.HomeFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.home_fragment.*
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

        viewModel.events.observe(this, Observer { event ->
            when (event) {
                HomeEvents.CLIENT_REGISTER -> navController?.navigate(HomeFragmentDirections.actionShowClientRegisterFragment())
                HomeEvents.CLIENT_LIST -> navController?.navigate(HomeFragmentDirections.actionShowClientListFragment())
                HomeEvents.PET_REGISTER -> navController?.navigate(HomeFragmentDirections.actionShowPetRegisterFragment())
                else -> Toast.makeText(
                    context,
                    getString(R.string.in_process),
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        setupToobar(toolbar, false)
    }
}