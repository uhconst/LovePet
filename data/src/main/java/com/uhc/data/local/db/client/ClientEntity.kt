package com.uhc.data.local.db.client

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Constancio on 2019-08-04.
 */
@Entity(tableName = "client")
data class ClientEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val name: String,

    val doc: String,

    val email: String,

    val phone1: String,

    val phone2: String,

    val street: String,

    val number: String,

    val district: String,

    @ColumnInfo(name = "post_code")
    val postCode: String
)