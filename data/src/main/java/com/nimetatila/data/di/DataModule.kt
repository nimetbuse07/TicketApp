package com.nimetatila.data.di

import com.nimetatila.core.domain.AuthRepository
import com.nimetatila.data.remote.AuthApi
import com.nimetatila.data.repository.AuthRepositoryImpl
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlin.math.sin

private  const val BASE_URL = "https://tickets-api.halitkalayci.com/"
val dataModule = module {
    //Scope (Kapsam)
    //3 temel seçenek

    //Yaşam döngüsündeki bağımlılığın davranış biçimi

    //Single(Singleton) -> Uygulama yaşam döngüsü boyunca tek örnek
    single {
        Json{
            ignoreUnknownKeys = true // Cevapta var olan ama classta olmayan alanları ignore et.
            explicitNulls = false
            isLenient = false
        }
    }

    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    //httpclient görevi = http isteklerini yönetmek
    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("BASE_URL")
            .client(get<OkHttpClient>())
            .addConverterFactory(get<Json>().asConverterFactory("application/json".toMediaType()))
            .build()
    }

    single { get<Retrofit>().create(AuthApi::class.java) }

    // Koin'e şunu diyoruz =  AuthRepository gerektiğinde şunu ver :
    single<AuthRepository> {
        AuthRepositoryImpl(
            authApi = get()
        // get(): Koin der ki: AuthRepositoryImpl için bir şey lazım -> ne istiyor -> AuthApi istiyor -> verilir
        )
    }

    // factory -> her çağrıldığı noktada yeni instance üretir. Her fonksiyon için birer örnek

    // scoped -> Class -Z tüm fonksiyonlarına 1 örnek

}