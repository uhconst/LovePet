package com.uhc.lovepet.di

import com.uhc.data.firebase.auth.FirebaseAuthServiceImpl
import com.uhc.data.repository.ClientRepositoryImpl
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.domain.interactor.ClientsUseCase
import com.uhc.domain.repository.ClientRepository
import org.koin.dsl.module

val domainModule = module {

    single<ClientRepository> { ClientRepositoryImpl(get()) }

    factory { ClientsUseCase(get()) }

    single { FirebaseAuthServiceImpl(get()) as FirebaseAuthService }
}