package com.uhc.presentation.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uhc.domain.interactor.ClientsUseCase
import com.uhc.domain.model.Client
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.EventLiveData

/**
 * Created by Constancio on 2019-05-25.
 */
class ClientRegisterViewModel(
    private val clientsUseCase: ClientsUseCase
) : BaseViewModel() {

    val name = MutableLiveData<String>()
    val cpf = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val phone1 = MutableLiveData<String>()
    val phone2 = MutableLiveData<String>()
    val street = MutableLiveData<String>()
    val number = MutableLiveData<String>()
    val district = MutableLiveData<String>()
    val postalCode = MutableLiveData<String>()

    private val _event = EventLiveData<ClientRegisterEvent>()
    val event: LiveData<ClientRegisterEvent> get() = _event

    fun onSaveClick() {
        clientsUseCase.saveClient(getClient())
        _event.postValue(ClientRegisterEvent.GO_BACK)
    }

    private fun getClient(): Client = Client(
        name = name.value.orEmpty(),
        doc = cpf.value.orEmpty(),
        email = email.value.orEmpty(),
        phone1 = phone1.value.orEmpty(),
        phone2 = phone2.value.orEmpty(),
        street = street.value.orEmpty(),
        number = number.value.orEmpty(),
        district = district.value.orEmpty(),
        postCode = postalCode.value.orEmpty()
    )
}

enum class ClientRegisterEvent {
    GO_BACK
}