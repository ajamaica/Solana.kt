package com.solana.models

import com.solana.models.buffer.*
import com.solana.vendor.borshj.BorshCodable
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProgramAccount<T: BorshCodable>(
    val account: BufferInfo<T>,
    val pubkey: String
)