package com.uhc.data.local.db.client

import androidx.room.*
import io.reactivex.Single

/**
 * Created by Constancio on 2019-08-04.
 */
@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClient(client: ClientEntity)

    @Delete
    fun deleteClient(client: ClientEntity)

    @Query("SELECT * FROM client WHERE id = :id LIMIT 1")
    fun getClient(id: Long): ClientEntity?

    @Query("SELECT * FROM client")
    fun getClients(): Single<List<ClientEntity>>
}