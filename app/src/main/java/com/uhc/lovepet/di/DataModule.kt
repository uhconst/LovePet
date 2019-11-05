package com.uhc.lovepet.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.uhc.data.local.db.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { AppDatabase.createDatabase(androidApplication()) }

    single { get<AppDatabase>().clientDao() }

    single { get<AppDatabase>().petDao() }

    single { FirebaseAuth.getInstance()}

    single { FirebaseDatabase.getInstance()}
}