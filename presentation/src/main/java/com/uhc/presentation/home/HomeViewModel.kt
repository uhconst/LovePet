package com.uhc.presentation.home

import androidx.lifecycle.LiveData
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.EventLiveData

class HomeViewModel : BaseViewModel() {
    private val _events = EventLiveData<HomeEvents>()
    val events: LiveData<HomeEvents> get() = _events

    fun onClientRegisterClick() {
        _events.postValue(HomeEvents.CLIENT_REGISTER)
    }
}

enum class HomeEvents {
    CLIENT_REGISTER
}