package com.uhc.data.repository

/**
 * Created by Constancio on 2/8/19.
 */
import com.uhc.data.local.db.transaction.TransactionDao
import com.uhc.data.remote.TransactionService
import com.uhc.domain.exception.DefaultException
import com.uhc.domain.model.Transaction
import com.uhc.domain.repository.TransactionRepository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class TransactionRepositoryImpl(
    private val service: TransactionService,
    private val dao: TransactionDao
) : TransactionRepository {

    override fun getTransactions(page: Int, per_page: Int): Single<List<Transaction>> {
        return service.getTransactions(page, per_page)
            .subscribeOn(Schedulers.io())
            .onErrorResumeNext {
                //If some error occur treat Exception here
                Single.error(DefaultException())
            }
            .map { it.results }
            .flattenAsObservable { it }
            .map {
                it.toTransaction()
            }
            .toList()
    }
}