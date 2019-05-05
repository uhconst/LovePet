package com.uhc.lovepet.di

import com.uhc.presentation.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel() }

//    factory { TransactionRecyclerAdapter() }

}