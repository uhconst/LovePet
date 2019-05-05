package com.uhc.presentation

import android.os.Bundle
import com.uhc.presentation.databinding.MainActivityBinding
import com.uhc.presentation.ui.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<MainActivityBinding>() {
    val viewModel : MainViewModel by viewModel()

    override fun getLayoutRes(): Int = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel


//        observeData()
    }

//    override fun onResume() {
//        super.onResume()
//        viewModel.fetchTransactions()
//    }
//
//    private fun observeData() {
////        viewModel.transactions.observeNotNull(this) {
////            transactionRecyclerAdapter.notifyChanged(it)
////        }
//
//        viewModel.error.observeNotNull(this) {
//            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
//        }
//    }
}