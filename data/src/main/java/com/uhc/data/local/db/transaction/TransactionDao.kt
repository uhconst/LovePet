package com.uhc.data.local.db.transaction

import androidx.room.*
import io.reactivex.Single

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favoriteTransactionEntity: TransactionEntity)

    @Delete
    fun deleteFavorite(favoriteTransactionEntity: TransactionEntity)

    @Query("SELECT * FROM tb_transaction WHERE id = :id LIMIT 1")
    fun findFavorite(id: Long): TransactionEntity?

    @Query("SELECT * FROM tb_transaction")
    fun findFavorites(): Single<List<TransactionEntity>>

}