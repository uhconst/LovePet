package com.uhc.data.local.db.transaction

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Constancio on 2/8/19.
 */
@Entity(tableName = "tb_transaction")
data class TransactionEntity(
    @PrimaryKey val id: Long
)