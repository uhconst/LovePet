package com.uhc.domain.interactor

import com.uhc.domain.model.Transaction
import com.uhc.domain.repository.TransactionRepository
import io.reactivex.Single

/**
 * Created by Constancio on 31/01/19.
 */
class GetTransactionsUseCase(
    private val transactionRepository: TransactionRepository
) {

    fun getTransactions(page: Int, per_page: Int): Single<List<Transaction>> {
        return transactionRepository.getTransactions(page, per_page)
    }
}