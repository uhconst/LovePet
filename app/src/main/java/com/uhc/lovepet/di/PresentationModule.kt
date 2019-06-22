package com.uhc.lovepet.di

import com.uhc.presentation.MainViewModel
import com.uhc.presentation.client.ClientListViewModel
import com.uhc.presentation.client.ClientRegisterViewModel
import com.uhc.presentation.home.HomeViewModel
import com.uhc.presentation.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    /** Main */
    viewModel { MainViewModel() }

    /** Login */
    viewModel { LoginViewModel(get()) }

    /** Home */
    viewModel { HomeViewModel() }

    /** Client Register */
    viewModel { ClientRegisterViewModel(get()) }

    /** Client List */
    viewModel { ClientListViewModel(get()) }
}