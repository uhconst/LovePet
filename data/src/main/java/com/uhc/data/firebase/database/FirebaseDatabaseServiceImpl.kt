package com.uhc.data.firebase.database

import com.google.firebase.database.FirebaseDatabase
import com.uhc.domain.firebase.database.FirebaseDatabaseService
import com.uhc.domain.model.Client

/**
 * Created by Constancio on 2019-05-12.
 */
class FirebaseDatabaseServiceImpl(
    private val fbDatabase: FirebaseDatabase
) : FirebaseDatabaseService {

    override fun writeNewClient(client: Client) {
        fbDatabase
            .reference
            .child("client")
            .push()
            .setValue(client)
    }
}