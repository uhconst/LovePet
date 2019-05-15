package com.uhc.domain.firebase.auth

import com.uhc.domain.model.User
import io.reactivex.Observable

/**
 * Created by Constancio on 2019-05-14.
 */
interface FirebaseAuthService {
    fun login(user: User?): Observable<Boolean>
}