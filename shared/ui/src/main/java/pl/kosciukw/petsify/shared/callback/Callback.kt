package pl.kosciukw.petsify.shared.callback

import kotlinx.coroutines.suspendCancellableCoroutine
import pl.kosciukw.petsify.shared.mapper.ApiToDomainErrorMapper
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun suspendCallback(
    errorMapper: ApiToDomainErrorMapper? = null,
    wrappedApiCall: (() -> Unit, (Throwable) -> Unit) -> Unit
) {
    return suspendCancellableCoroutine { continuation ->
        wrappedApiCall(
            { continuation.resume(Unit) },
            { continuation.resumeWithException(errorMapper?.map(it) ?: it) }
        )
    }
}

suspend fun suspendCallback(
    errorMapper: ApiToDomainErrorMapper? = null,
    wrappedApiCall: (() -> Unit, (Throwable) -> Unit) -> Unit,
    alternativeExceptionMapping: ((Throwable) -> Throwable)? = null
) {
    return suspendCancellableCoroutine { continuation ->
        wrappedApiCall(
            { continuation.resume(Unit) },
            {
                val exception = errorMapper?.map(it) ?: it
                val alternativeException = alternativeExceptionMapping?.invoke(exception)
                continuation.resumeWithException(alternativeException ?: exception)
            }
        )
    }
}

suspend fun <T> suspendCallbackWithData(
    errorMapper: ApiToDomainErrorMapper? = null,
    wrappedApiCall: ((T) -> Unit, (Throwable) -> Unit) -> Unit
): T {
    return suspendCancellableCoroutine { continuation ->
        wrappedApiCall(
            { continuation.resume(it) },
            { continuation.resumeWithException(errorMapper?.map(it) ?: it) }
        )
    }
}

suspend fun <T> suspendCallbackWithData(
    errorMapper: ApiToDomainErrorMapper? = null,
    wrappedApiCall: ((T) -> Unit, (Throwable) -> Unit) -> Unit,
    alternativeExceptionMapping: ((Throwable) -> Throwable)? = null
): T {
    return suspendCancellableCoroutine { continuation ->
        wrappedApiCall(
            { continuation.resume(it) },
            {
                val exception = errorMapper?.map(it) ?: it
                val alternativeException = alternativeExceptionMapping?.invoke(exception)
                continuation.resumeWithException(alternativeException ?: exception)
            }
        )
    }
}

suspend fun <T> mapResult(
    errorMapper: ApiToDomainErrorMapper,
    apiCall: suspend () -> T
): T {
    return runCatching {
        apiCall()
    }.getOrElse {
        throw errorMapper.map(it)
    }
}