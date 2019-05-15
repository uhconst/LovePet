package com.uhc.lovepet.di

import com.uhc.data.firebase.auth.FirebaseAuthServiceImpl
import com.uhc.data.firebase.database.FirebaseDatabaseServiceImpl
import com.uhc.data.repository.TransactionRepositoryImpl
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.domain.firebase.database.FirebaseDatabaseService
import com.uhc.domain.interactor.GetTransactionsUseCase
import com.uhc.domain.repository.TransactionRepository
import org.koin.dsl.module

val domainModule = module {

    single<TransactionRepository> { TransactionRepositoryImpl(get(), get()) }

    factory { GetTransactionsUseCase(get()) }

    single { FirebaseDatabaseServiceImpl(get()) as FirebaseDatabaseService }

    single { FirebaseAuthServiceImpl(get()) as FirebaseAuthService }
}