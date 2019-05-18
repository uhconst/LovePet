package com.uhc.data.firebase.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.uhc.domain.firebase.auth.FirebaseAuthService
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Constancio on 2019-05-14.
 */
class FirebaseAuthServiceImpl(
    private val auth: FirebaseAuth
) : FirebaseAuthService {

    override fun login(username: String, password: String): Completable =
        Completable.create { emitter ->
            auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // todo replace with a login wrapper (to be created)
                        Log.d("Login", "signInWithEmail:success")
                        emitter.onComplete()
                    } else {
                        // todo replace with a login wrapper (to be created)
                        Log.w(
                            "Login",
                            "signInWithEmail:failure",
                            task.exception
                        )
                        emitter.onError(Throwable("Error signInWithEmail:"))
                    }
                }
        }.subscribeOn(Schedulers.io())
}
