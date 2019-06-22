package com.uhc.presentation.client

import android.os.Bundle
import android.view.View
import com.uhc.presentation.R
import com.uhc.presentation.databinding.ClientListFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.client_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Constancio on 2019-06-22.
 */
class ClientListFragment : BaseFragment<ClientListFragmentBinding>() {
    val viewModel: ClientListViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.client_list_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        setupToobar(toolbar)
    }
}