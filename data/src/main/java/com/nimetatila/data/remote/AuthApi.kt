package com.nimetatila.data.remote

import com.nimetatila.data.dto.CredentialsDto
import com.nimetatila.data.dto.RefreshRequestDto
import com.nimetatila.data.dto.TokenPairDto
import retrofit2.http.Body
import retrofit2.http.POST



// Retrofit ile spesifik bir API'e istek atan kodu yazdık.
interface AuthApi {
    @POST("/auth/login")
    suspend fun login(@Body body: CredentialsDto): TokenPairDto

    @POST("/auth/register")
    suspend fun register(@Body body: CredentialsDto): TokenPairDto

    @POST("/auth/refresh")
    suspend fun refresh(@Body body: RefreshRequestDto): TokenPairDto
}
//API ile konuşan en alt seviye katman
//Retrofit için yazılmış bir API katmanı
//endpointlere POST atar
//body olarak email/Password gönderir
//response olarak token alır

//Retrofit arka planda:
//-HTTP request oluşturur
//-JSON'a çevirir
//-server'a yollar
//-cevabı alır
//DTO'ya çevirir

//suspend => network işlemi
//ana thread'i bloklamaması lazım
//coroutine ile çalışır

//DTO => API ile konuşurken kullanılan veri formatı
//request => CredentialsDto
//response => TokenPairDto

//direkt backende bağlı, API değişirse burasıdeğişebilir