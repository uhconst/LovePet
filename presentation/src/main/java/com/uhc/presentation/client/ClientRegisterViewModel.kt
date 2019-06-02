package com.uhc.presentation.client

import androidx.lifecycle.MutableLiveData
import com.uhc.domain.firebase.database.FirebaseDatabaseService
import com.uhc.domain.model.Client
import com.uhc.presentation.ui.base.BaseViewModel

/**
 * Created by Constancio on 2019-05-25.
 */
class ClientRegisterViewModel(
    val firebaseDatabaseService: FirebaseDatabaseService
) : BaseViewModel() {

    val name = MutableLiveData<String>()
    val cpf = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val telefone1 = MutableLiveData<String>()
    val telefone2 = MutableLiveData<String>()
    val rua = MutableLiveData<String>()
    val numero = MutableLiveData<String>()
    val bairro = MutableLiveData<String>()
    val cep = MutableLiveData<String>()

    fun onSaveClick() {
        firebaseDatabaseService.writeNewClient(getClient())

    }

    private fun getClient(): Client = Client(
        name = name.value.orEmpty(),
        cpf = cpf.value.orEmpty(),
        email = email.value.orEmpty(),
        telefone1 = telefone1.value.orEmpty(),
        telefone2 = telefone2.value.orEmpty(),
        rua = rua.value.orEmpty(),
        numero = numero.value.orEmpty(),
        bairro = bairro.value.orEmpty(),
        cep = cep.value.orEmpty()
    )
}