package com.uhc.data.remote.dto

import com.uhc.domain.model.Transaction

/**
 * Created by Constancio on 2/8/19.
 */
sealed class TransactionDto {

    data class Response(
        val id: Long,
        val userId: Long,
        val title: String
    ) {

        fun toTransaction() = Transaction(
            id,
            userId,
            title
        )
    }
}