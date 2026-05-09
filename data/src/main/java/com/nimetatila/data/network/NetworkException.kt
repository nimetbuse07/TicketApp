package com.nimetatila.data.network

// Bağlantı kopuk, timeout, dns çözümleme
class NetworkException(cause : Throwable) : RuntimeException("Network Error", cause)

//Sunucu 4xx, 5xx kodlu hatalar
class ApiException(
    val code: Int,
    val errorMessage: String?,
    cause: Throwable? = null
) : RuntimeException("HTTP $code: $errorMessage", cause)