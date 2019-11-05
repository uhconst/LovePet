package com.uhc.domain.repository

import com.uhc.domain.model.Client
import io.reactivex.Completable
import io.reactivex.Single

interface ClientRepository {

    fun saveClient(client: Client): Completable

    fun getClients(): Single<List<Client>>
}