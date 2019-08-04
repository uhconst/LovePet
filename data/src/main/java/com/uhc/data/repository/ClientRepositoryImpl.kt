package com.uhc.data.repository

/**
 * Created by Constancio on 2/8/19.
 */
import com.uhc.data.local.db.client.ClientDao
import com.uhc.data.local.db.client.ClientEntity
import com.uhc.domain.model.Client
import com.uhc.domain.repository.ClientRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class ClientRepositoryImpl(
    private val dao: ClientDao
) : ClientRepository {

    override fun saveClient(client: Client): Completable {
        return Completable.create {
            dao.insertClient(client.toClientEntity())
            it.onComplete()
        }.subscribeOn(Schedulers.io())
    }

    override fun getClients(): Single<List<Client>> {
        return dao.getClients()
            .map { clientList ->
                clientList.map { clientEntity ->
                    clientEntity.toClient()
                }
            }
            .subscribeOn(Schedulers.io())
    }

    private fun ClientEntity.toClient(): Client =
        Client(
            id = id,
            name = name,
            doc = doc,
            email = email,
            phone1 = phone1,
            phone2 = phone2,
            street = street,
            number = number,
            district = district,
            postCode = postCode
        )

    private fun Client.toClientEntity(): ClientEntity =
        ClientEntity(
            id = id,
            name = name,
            doc = doc,
            email = email,
            phone1 = phone1,
            phone2 = phone2,
            street = street,
            number = number,
            district = district,
            postCode = postCode
        )
}