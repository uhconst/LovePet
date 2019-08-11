package com.uhc.presentation.pet

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.uhc.presentation.R
import com.uhc.presentation.databinding.PetRegisterFragmentBinding
import com.uhc.presentation.ui.base.BaseFragment
import kotlinx.android.synthetic.main.pet_register_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Created by Constancio on 2019-08-11.
 */
class PetRegisterFragment : BaseFragment<PetRegisterFragmentBinding>() {
    val viewModel: PetRegisterViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.pet_register_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel

        setupToobar(toolbar)

        viewModel.event.observe(this, Observer { event ->
            when (event) {
                PetRegisterEvent.GO_BACK -> onBackPressed()
                PetRegisterEvent.ERROR -> Log.e("Error saving", "Error saving pet.") // todo refactor logs
                else -> Log.d("Nav", "No event found.") // todo refactor logs
            }
        })
    }
}