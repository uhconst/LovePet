package com.uhc.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uhc.domain.exception.DefaultException
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.presentation.livedata.EventLiveData
import com.uhc.presentation.ui.base.BaseViewModel
import com.uhc.presentation.utils.SingleLiveData

/**
 * Created by Constancio on 2019-05-04.
 */
class LoginViewModel(val firebaseAuth: FirebaseAuthService) : BaseViewModel() {

    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _events = EventLiveData<LoginEvents>()
    val events: LiveData<LoginEvents> get() = _events

    val error = SingleLiveData<DefaultException>()

    fun onLoginClick() {
        subscribeCompletable(
            observable = firebaseAuth.login(username.value.orEmpty(), password.value.orEmpty())
                .doOnSubscribe { startProgress() }
                .doFinally { stopProgress() },
            complete = { _events.postValue(LoginEvents.GO_TO_HOME) },
            error = { error.postValue(it) }
        )
    }
}

enum class LoginEvents {
    GO_TO_HOME
}