package com.uhc.presentation.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uhc.domain.interactor.ClientsUseCase
import com.uhc.domain.model.Client
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.EventLiveData

/**
 * Created by Constancio on 2019-06-22.
 */
class ClientListViewModel(
    clientsUseCase: ClientsUseCase
) : BaseViewModel() {
    private val _clients = MutableLiveData<List<Client>>()
    val clients: LiveData<List<Client>> get() = _clients

    private val _events = EventLiveData<ClientListEvents>()
    val events: LiveData<ClientListEvents> get() = _events

    init {
        subscribeSingle(
            observable = clientsUseCase.getClients()
                .doOnSubscribe { startProgress() }
                .doFinally { stopProgress() },
            success = { _clients.postValue(it) },
            error = { _events.postValue(ClientListEvents.CLIENTS_ERROR) }
        )
    }
}

enum class ClientListEvents {
    CLIENTS_ERROR
}