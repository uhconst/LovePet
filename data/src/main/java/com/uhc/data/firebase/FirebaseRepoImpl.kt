package com.uhc.data.firebase

import com.google.firebase.database.FirebaseDatabase
import com.uhc.domain.firebase.FirebaseRepo
import com.uhc.domain.repository.User

/**
 * Created by Constancio on 2019-05-12.
 */
class FirebaseRepoImpl(
    val fbDatabase: FirebaseDatabase
) : FirebaseRepo {

    override fun writeNewUser(email: String, password: String) {
        val user = User(email, password) // todo

        fbDatabase
            .reference
            .child("users")
            .setValue(user)
    }
}