package com.uhc.domain.model

/**
 * Created by Constancio on 2019-06-02.
 */
data class Client (
    val id: Long? = null,
    val name: String,
    val doc: String,
    val email: String,
    val phone1: String,
    val phone2: String,
    val street: String,
    val number: String,
    val district: String,
    val postCode: String
)