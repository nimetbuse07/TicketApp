package com.nimetatila.ticketapp.di

import com.nimetatila.ticketapp.viewmodel.LoginViewModel
import com.nimetatila.ticketapp.viewmodel.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    //viewModel
    viewModelOf(:: LoginViewModel)
    viewModelOf(:: RegisterViewModel)
}

//Koin'e => LoginViewModel nasıl oluşturulacağını biliyorum (constructor’ı var), gerektiğinde Koin oluşturur
//ViewModel => UI katmanına ait. O yüzden app katmanında tanımlanır
//di => Bağımlılıkları burada tanımlıyoruz
//Koin'in oluşturmasını istediğimiz şeyleri burada yazarız
//Sistemin oluşturmasını istiyorsak => di içerisine