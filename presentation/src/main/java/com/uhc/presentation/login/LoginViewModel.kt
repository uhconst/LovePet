package com.uhc.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.domain.model.User
import com.uhc.presentation.ui.base.BaseViewModel

/**
 * Created by Constancio on 2019-05-04.
 */
class LoginViewModel(val firebaseAuth: FirebaseAuthService) : BaseViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> get() = _user

    fun onLoginClick() {
        firebaseAuth.login(user.value)
//        firebaseRepo.writeNewUser("teste2", "456") //todo
    }
}