package com.uhc.domain.model

/**
 * Created by Constancio on 2019-08-11.
 */
data class Pet(
    val id: Long? = null,
    val name: String,
    val breed: String,
    val colour: String,
    val size: String,
    val dateOfBirth: String
)