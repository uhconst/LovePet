package com.uhc.presentation.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.uhc.presentation.R
import com.uhc.presentation.databinding.LoginFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Constancio on 2019-05-04.
 */
class LoginFragment : BaseFragment<LoginFragmentBinding>() {
    val viewModel: LoginViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.login_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        viewModel.events.observe(this, Observer { event ->
            when (event) {
                LoginEvents.GO_TO_HOME -> navController?.navigate(LoginFragmentDirections.actionShowHomeFragment())
            }
        })
    }
}