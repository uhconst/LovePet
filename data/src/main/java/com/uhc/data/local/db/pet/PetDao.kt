package com.uhc.data.local.db.pet

import androidx.room.*
import io.reactivex.Single

/**
 * Created by Constancio on 2019-08-11.
 */
@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPet(pet: PetEntity)

    @Delete
    fun deletePet(pet: PetEntity)

    @Query("SELECT * FROM pet WHERE id = :id LIMIT 1")
    fun getPet(id: Long): PetEntity?

    @Query("SELECT * FROM pet")
    fun getPets(): Single<List<PetEntity>>
}