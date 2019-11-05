package com.uhc.domain.interactor

import com.uhc.domain.model.Pet
import com.uhc.domain.repository.PetRepository
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Constancio on 2019-08-11.
 */
class PetsUseCase (
    private val petRepository: PetRepository
) {

    fun savePet(pet: Pet): Completable {
        return petRepository.savePet(pet)
    }

    fun getPets(): Single<List<Pet>> {
        return petRepository.getPets()
    }
}