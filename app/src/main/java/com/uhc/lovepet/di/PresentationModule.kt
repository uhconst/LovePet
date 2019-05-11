package com.uhc.lovepet.di

import com.uhc.presentation.MainViewModel
import com.uhc.presentation.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel() }
    viewModel { LoginViewModel() }

//    factory { TransactionRecyclerAdapter() }

}