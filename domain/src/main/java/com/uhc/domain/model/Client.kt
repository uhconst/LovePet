package com.uhc.domain.model

/**
 * Created by Constancio on 2019-06-02.
 */
data class Client (
    val name: String,
    val cpf: String,
    val email: String,
    val telefone1: String,
    val telefone2: String,
    val rua: String,
    val numero: String,
    val bairro: String,
    val cep: String
)