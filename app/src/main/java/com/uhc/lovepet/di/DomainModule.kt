package com.uhc.lovepet.di

import com.uhc.data.firebase.FirebaseRepoImpl
import com.uhc.data.repository.TransactionRepositoryImpl
import com.uhc.domain.firebase.FirebaseRepo
import com.uhc.domain.interactor.GetTransactionsUseCase
import com.uhc.domain.repository.TransactionRepository
import org.koin.dsl.module

val domainModule = module {

    single<TransactionRepository> { TransactionRepositoryImpl(get(), get()) }

    factory { GetTransactionsUseCase(get()) }

    single { FirebaseRepoImpl(get()) as FirebaseRepo }
}