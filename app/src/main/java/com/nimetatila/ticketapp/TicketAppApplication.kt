package com.nimetatila.ticketapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


//Uygulama başladığında Activitylerden önce oluşturulur
//Singleton (Tek bir instance olarak memoryde kalır)
//Uygulama kapanana kaddar yoko edilmez

class TicketAppApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TicketAppApplication) //
            modules(

            )
        }
    }
}