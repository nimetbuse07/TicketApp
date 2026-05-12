package com.nimetatila.ticketapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.nimetatila.core.ui.theme.Surface
import com.nimetatila.core.ui.theme.TicketAppTheme
import com.nimetatila.ticketapp.navigation.AppNavHost
import com.nimetatila.ticketapp.screen.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicketAppTheme {
                AppNavHost()
            }
        }
    }
}


// app -> UI + entry point
// data -> API,database
// domain -> business logic
// monolith yerine modüler mimari, kod karmaşasını azaltmak, büyük projeyi yönetilebilir hale getirmek

// libs.versions.toml -> dependency merkezi -> dependency management
// kütüphane isimleri,versiyonlar

// buil.gradle içinde implementation yapıyoruz
// toml = sadece tanım (definition) -> "Retrofit diye bir kütüphane var"
// buil.gradle = kullanım (usage) -> "Ben bunu bu modülde kullanıyorum"

//versiyonları tek yerden yönetmek
//tüm modüllerde aynı versiyou kullanmak
//daha temiz Gradle dosyası

// dependecy injection -> bir sınıfın ihtiyacı olan nesneleri kendisi oluşturmak yerine dışarıdan almak

// Hilt = Android için Dependency Injection kütüphanesi
// senin yerine object oluşturan ve birbirine bağlayan sistem
// dependency'leri otomatik üretir ve inject eder

// entry point -> uygulamanın başlangıç noktası
//