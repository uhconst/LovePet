package com.uhc.domain.repository

import com.uhc.domain.model.Transaction
import io.reactivex.Single

interface TransactionRepository {

    fun getTransactions(page: Int, per_page: Int): Single<List<Transaction>>
}