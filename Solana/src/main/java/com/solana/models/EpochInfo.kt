package com.solana.models

import com.squareup.moshi.Json

class EpochInfo (
    @Json(name = "absoluteSlot")
    val absoluteSlot: Long,

    @Json(name = "blockHeight")
    val blockHeight: Long,

    @Json(name = "epoch")
    val epoch: Long,

    @Json(name = "slotIndex")
    val slotIndex: Long,

    @Json(name = "slotsInEpoch")
    val slotsInEpoch: Long
)