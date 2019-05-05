package com.uhc.lovepet.di

import com.uhc.data.local.db.AppDatabase
import com.uhc.data.remote.TransactionService
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { AppDatabase.createDatabase(androidApplication()) }

    single { get<AppDatabase>().transactionDao() }

    single { TransactionService.createTransactionService() }
}