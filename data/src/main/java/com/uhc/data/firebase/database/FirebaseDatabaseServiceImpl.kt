package com.uhc.data.firebase.database

import com.google.firebase.database.FirebaseDatabase
import com.uhc.domain.firebase.database.FirebaseDatabaseService

/**
 * Created by Constancio on 2019-05-12.
 */
class FirebaseDatabaseServiceImpl(
    private val fbDatabase: FirebaseDatabase
) : FirebaseDatabaseService {

    // todo just an example for saving something
    override fun writeNewUser(email: String, password: String) {
//        val user = User(email, password) // todo

        fbDatabase
            .reference
            .child("users")
            .setValue(/*user*/null)
    }
}