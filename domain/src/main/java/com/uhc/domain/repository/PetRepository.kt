package com.uhc.domain.repository

import com.uhc.domain.model.Pet
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Constancio on 2019-08-11.
 */
interface PetRepository {
    fun savePet(pet: Pet): Completable

    fun getPets(): Single<List<Pet>>
}