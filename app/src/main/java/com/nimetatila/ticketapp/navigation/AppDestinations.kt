package com.nimetatila.ticketapp.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Register

@Serializable
object Home

//@Serializable => Kotlinx Serialization kütüphanesine ait anotasyon
//class/object veriye dönüştürülebilir ve tekrar oluşturulabilir
//Route'ları string yerine type-safe object olarak tercih edilir
//navigation objecti alır, serialize eder ve route olarak kullanır