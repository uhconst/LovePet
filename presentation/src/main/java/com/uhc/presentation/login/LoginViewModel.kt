package com.uhc.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.presentation.BuildConfig
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.EventLiveData

/**
 * Created by Constancio on 2019-05-04.
 */
class LoginViewModel(
    private val firebaseAuth: FirebaseAuthService
) : BaseViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _events = EventLiveData<LoginEvents>()
    val events: LiveData<LoginEvents> get() = _events

    init {
        if (BuildConfig.DEBUG) {
            username.value = "teste@teste.com"
            password.value = "teste123"
        }
    }

    fun onLoginClick() {
        subscribeSingle(
            observable = firebaseAuth.login(username.value.orEmpty(), password.value.orEmpty())
                .doOnSubscribe { startProgress() }
                .doFinally { stopProgress() },
            success = { _events.postValue(LoginEvents.GO_TO_HOME) },
            error = { _events.postValue(LoginEvents.LOGIN_ERROR) }
        )
    }
}

enum class LoginEvents {
    GO_TO_HOME,
    LOGIN_ERROR
}