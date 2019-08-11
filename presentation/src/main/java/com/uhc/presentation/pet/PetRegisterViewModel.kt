package com.uhc.presentation.pet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uhc.domain.interactor.PetsUseCase
import com.uhc.domain.model.Pet
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.EventLiveData

/**
 * Created by Constancio on 2019-08-11.
 */
class PetRegisterViewModel(
    private val petsUseCase: PetsUseCase
) : BaseViewModel() {

    val name = MutableLiveData<String>()
    val breed = MutableLiveData<String>()
    val colour = MutableLiveData<String>()
    val size = MutableLiveData<String>()
    val dateOfBirth = MutableLiveData<String>()

    private val _event = EventLiveData<PetRegisterEvent>()
    val event: LiveData<PetRegisterEvent> get() = _event

    fun onSaveClick() {
        subscribeCompletable(
            observable = petsUseCase.savePet(getPet()),
            complete = { _event.postValue(PetRegisterEvent.GO_BACK) },
            error = { _event.postValue(PetRegisterEvent.ERROR) }
        )
    }

    private fun getPet(): Pet = Pet(
        name = name.value.orEmpty(),
        breed = breed.value.orEmpty(),
        colour = colour.value.orEmpty(),
        size = size.value.orEmpty(),
        dateOfBirth = dateOfBirth.value.orEmpty()
    )
}

enum class PetRegisterEvent {
    GO_BACK,
    ERROR
}