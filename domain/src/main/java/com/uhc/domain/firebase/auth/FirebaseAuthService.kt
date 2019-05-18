package com.uhc.domain.firebase.auth

import io.reactivex.Completable

/**
 * Created by Constancio on 2019-05-14.
 */
interface FirebaseAuthService {
    fun login(username: String, password: String): Completable
}