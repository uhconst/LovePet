package com.uhc.data.repository

import com.uhc.data.local.db.pet.PetDao
import com.uhc.data.local.db.pet.PetEntity
import com.uhc.domain.model.Pet
import com.uhc.domain.repository.PetRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Created by Constancio on 2019-08-11.
 */
class PetRepositoryImpl(
    private val dao: PetDao
) : PetRepository {

    override fun savePet(pet: Pet): Completable {
        return Completable.create {
            dao.insertPet(pet.toPetEntity())
            it.onComplete()
        }.subscribeOn(Schedulers.io())
    }

    override fun getPets(): Single<List<Pet>> {
        return dao.getPets()
            .map { petList ->
                petList.map { petEntity ->
                    petEntity.toPet()
                }
            }
            .subscribeOn(Schedulers.io())
    }

    private fun PetEntity.toPet(): Pet =
        Pet(
            id = id,
            name = name,
            breed = breed,
            colour = colour,
            size = size,
            dateOfBirth = dateOfBirth
        )

    private fun Pet.toPetEntity(): PetEntity =
        PetEntity(
            id = id,
            name = name,
            breed = breed,
            colour = colour,
            size = size,
            dateOfBirth = dateOfBirth
        )
}