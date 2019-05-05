package com.uhc.presentation.home

import androidx.lifecycle.MutableLiveData
import com.uhc.domain.exception.DefaultException
import com.uhc.domain.interactor.GetTransactionsUseCase
import com.uhc.domain.model.Transaction
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.SingleLiveData

class HomeViewModel(
    private val getTransactionsUseCase: GetTransactionsUseCase
) : BaseViewModel() {

    private var currentPage: Int = 1
    private var perPage: Int = 1000

    val transactions = MutableLiveData<List<Transaction>>()

    val error = SingleLiveData<DefaultException>()

    fun fetchTransactions() {
        subscribeSingle(
            observable = getTransactionsUseCase.getTransactions(currentPage, perPage)
                .doOnSubscribe { showLoading.set(true) }
                .doFinally { showLoading.set(false) },
            success = {
                transactions.postValue(it)
            },
            error = { error.postValue(it) }
        )
    }

}