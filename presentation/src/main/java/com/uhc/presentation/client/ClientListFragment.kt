package com.uhc.presentation.client

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uhc.presentation.R
import com.uhc.presentation.databinding.ClientListFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import com.uhc.presentation.ui.extensions.observeNotNull
import kotlinx.android.synthetic.main.client_list_fragment.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Constancio on 2019-06-22.
 */
class ClientListFragment : BaseFragment<ClientListFragmentBinding>() {
    val viewModel: ClientListViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.client_list_fragment

    private val clientAdapter by inject<ClientAdapter>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        setupClientsList()
        setupToobar(toolbar)

        observeData()
    }

    private fun setupClientsList() {
//        clientAdapter.listener = this //todo
        binding.rvClients.layoutManager = LinearLayoutManager(
            this.context,
            RecyclerView.VERTICAL,
            false
        )
        binding.rvClients.adapter = clientAdapter
    }

    private fun observeData() {
        viewModel.clients.observeNotNull(this) {
            clientAdapter.notifyChanged(it)
        }

//        viewModel.error.observeNotNull(this) {
//            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//        }
    }
}