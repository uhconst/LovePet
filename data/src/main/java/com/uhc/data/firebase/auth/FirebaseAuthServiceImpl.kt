package com.uhc.data.firebase.auth

import android.util.Log
import com.androidhuman.rxfirebase2.auth.rxSignInWithEmailAndPassword
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.domain.model.LoginResponse
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by Constancio on 2019-05-14.
 */
class FirebaseAuthServiceImpl(
    private val auth: FirebaseAuth
) : FirebaseAuthService {

    override fun login(username: String, password: String): Single<LoginResponse> =
        auth.rxSignInWithEmailAndPassword(username, password)
            .map {
                it.toLoginResponse()
            }
            .doOnError {
                Log.e("Login error", it.message) // todo log
            }.subscribeOn(Schedulers.io())

    private fun AuthResult.toLoginResponse(): LoginResponse =
        LoginResponse(this.user.email.orEmpty())

}
