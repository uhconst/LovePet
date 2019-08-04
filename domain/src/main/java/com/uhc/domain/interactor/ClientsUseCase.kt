package com.uhc.domain.interactor

import com.uhc.domain.model.Client
import com.uhc.domain.repository.ClientRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Constancio on 31/01/19.
 */
class ClientsUseCase(
    private val clientRepository: ClientRepository
) {

    fun saveClient(client: Client): Completable {
        return clientRepository.saveClient(client)
    }

    fun getClients(): Single<List<Client>> {
        return clientRepository.getClients()
    }
}