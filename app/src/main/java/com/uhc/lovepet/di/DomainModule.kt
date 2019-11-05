package com.uhc.lovepet.di

import com.uhc.data.firebase.auth.FirebaseAuthServiceImpl
import com.uhc.data.repository.ClientRepositoryImpl
import com.uhc.data.repository.PetRepositoryImpl
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.domain.interactor.ClientsUseCase
import com.uhc.domain.interactor.PetsUseCase
import com.uhc.domain.repository.ClientRepository
import com.uhc.domain.repository.PetRepository
import org.koin.dsl.module

val domainModule = module {

    single<ClientRepository> { ClientRepositoryImpl(get()) }

    single<PetRepository> { PetRepositoryImpl(get()) }

    factory { ClientsUseCase(get()) }

    factory { PetsUseCase(get()) }

    single { FirebaseAuthServiceImpl(get()) as FirebaseAuthService }
}