package com.solana.api

import com.solana.networking.RpcRequest
import com.solana.networking.makeRequestResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.builtins.serializer

class GetFirstAvailableBlockRequest : RpcRequest() {
    override val method: String = "getFirstAvailableBlock"
}

internal fun GetFirstAvailableBlockSerializer() = Long.serializer()

fun Api.getFirstAvailableBlock(onComplete: ((Result<Long>) -> Unit)){
    CoroutineScope(dispatcher).launch {
        onComplete(getFirstAvailableBlock())
    }
}

suspend fun Api.getFirstAvailableBlock(): Result<Long> =
    router.makeRequestResult(GetFirstAvailableBlockRequest(), GetFirstAvailableBlockSerializer())
        .let { result ->
            @Suppress("UNCHECKED_CAST")
            if (result.isSuccess && result.getOrNull() == null)
                Result.failure(Error("Can not be null"))
            else result as Result<Long> // safe cast, null case handled above
        }