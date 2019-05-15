package com.uhc.data.firebase.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.uhc.domain.firebase.auth.FirebaseAuthService
import com.uhc.domain.model.User
import io.reactivex.Observable

/**
 * Created by Constancio on 2019-05-14.
 */
class FirebaseAuthServiceImpl(
    private val auth: FirebaseAuth
) : FirebaseAuthService {

    override fun login(user: User?): Observable<Boolean> =
        Observable.create { subscriber ->
            auth.signInWithEmailAndPassword(user?.username.orEmpty(), user?.password.orEmpty())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // todo replace with a login wrapper (to be created)
                        Log.d("Login", "signInWithEmail:success")
                        subscriber.onComplete()
                    } else {
                        // todo replace with a login wrapper (to be created)
                        Log.w(
                            "Login",
                            "signInWithEmail:failure",
                            task.exception
                        )
                        subscriber.onError(Throwable("Error signInWithEmail:"))
                    }
                }
        }
}
