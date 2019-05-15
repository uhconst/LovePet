package com.uhc.domain.firebase.database

/**
 * Created by Constancio on 2019-05-12.
 */
interface FirebaseDatabaseService {
    // TODO only a mock to implement writing into DB. Login will user it proper auth
    fun writeNewUser(email: String, password: String)
}