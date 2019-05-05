package com.uhc.data.remote

import com.uhc.data.remote.dto.TransactionDto
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface TransactionService {
    //todo mudar o get e tambem adicionar o limite de paginas
    @GET("api/transactions")
    fun getTransactions(@Query("page") page: Int, @Query("per_page") per_page: Int): Single<ResponseWrap<TransactionDto.Response>>

    companion object {
        //todo
        private const val API_KEY = "a6122c64e9f272fb827cb5d0f219aabb"
        //todo
        private const val BASE_URL = "http://35.230.147.152/"

        fun createTransactionService(): TransactionService {
            val client = OkHttpClient().newBuilder()
                .addInterceptor {
                    val url = it.request().url().newBuilder()
                        .addQueryParameter("api_key", API_KEY)
                        .build()

                    val request = it.request().newBuilder()
                        .url(url)
                        .build()

                    it.proceed(request)
                }
                .addInterceptor(getHttpLoggingInterceptor())
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BASE_URL)
                .build()
                .create(TransactionService::class.java)
        }

        private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            return loggingInterceptor
        }
    }
}