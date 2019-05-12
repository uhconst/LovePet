package com.uhc.presentation.login

import com.uhc.domain.firebase.FirebaseRepo
import com.uhc.presentation.ui.base.BaseViewModel

/**
 * Created by Constancio on 2019-05-04.
 */
class LoginViewModel(val firebaseRepo: FirebaseRepo) : BaseViewModel() {


    fun onLoginClick() {
        firebaseRepo.writeNewUser("teste2", "456") //todo
    }
}