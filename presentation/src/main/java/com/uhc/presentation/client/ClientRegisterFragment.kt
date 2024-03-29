package com.uhc.presentation.client

import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.uhc.presentation.R
import com.uhc.presentation.databinding.ClientRegisterFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.client_register_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Constancio on 2019-05-25.
 */
class ClientRegisterFragment : BaseFragment<ClientRegisterFragmentBinding>() {
    val viewModel: ClientRegisterViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.client_register_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        setupMasks()
        setupToobar(toolbar)

        viewModel.event.observe(this, Observer { event ->
            when (event) {
                ClientRegisterEvent.GO_BACK -> onBackPressed()
                ClientRegisterEvent.ERROR -> Log.e("Error saving", "Error saving client.") // todo refactor logs
                else -> Log.d("Nav", "No event found.") // todo refactor logs
            }
        })
    }

    private fun setupMasks() {
        clientRegisterPhone1.addTextChangedListener(PhoneNumberFormattingTextWatcher())
        clientRegisterPhone2.addTextChangedListener(PhoneNumberFormattingTextWatcher())
    }
}