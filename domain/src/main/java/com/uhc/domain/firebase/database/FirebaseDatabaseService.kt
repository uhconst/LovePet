package com.uhc.domain.firebase.database

import com.uhc.domain.model.Client

/**
 * Created by Constancio on 2019-05-12.
 */
interface FirebaseDatabaseService {

    fun writeNewClient(client: Client)
}