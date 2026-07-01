package com.movieapp.domain.model

/**
 * Wrapper genérico para representar o resultado de uma operação,
 * evitando expor exceptions diretamente para a camada de apresentação.
 */
sealed interface DataResult<out T> {
    data class Success<T>(val data: T) : DataResult<T>
    data class Error(val message: String, val throwable: Throwable? = null) : DataResult<Nothing>
}

inline fun <T> DataResult<T>.onSuccess(action: (T) -> Unit): DataResult<T> {
    if (this is DataResult.Success) action(data)
    return this
}

inline fun <T> DataResult<T>.onError(action: (String) -> Unit): DataResult<T> {
    if (this is DataResult.Error) action(message)
    return this
}
