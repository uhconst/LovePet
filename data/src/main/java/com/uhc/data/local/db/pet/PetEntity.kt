package com.uhc.data.local.db.pet

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Constancio on 2019-08-11.
 */
@Entity(tableName = "pet")
data class PetEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val name: String,

    val breed: String,

    val colour: String,

    val size: String,

    @ColumnInfo(name = "date_of_birth")
    val dateOfBirth: String
)