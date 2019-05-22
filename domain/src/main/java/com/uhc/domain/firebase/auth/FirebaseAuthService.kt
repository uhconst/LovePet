package com.uhc.domain.firebase.auth

import com.uhc.domain.model.LoginResponse
import io.reactivex.Single

/**
 * Created by Constancio on 2019-05-14.
 */
interface FirebaseAuthService {
    fun login(username: String, password: String): Single<LoginResponse>
}