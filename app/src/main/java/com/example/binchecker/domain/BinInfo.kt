package com.example.binchecker.domain

data class BinInfo(
    val scheme: String?,   // Платёжная система (Visa, MasterCard и т.д.)
    val type: String?,     // Тип карты (debit — дебетовая, credit — кредитная)
    val brand: String?,    // Маркетинговое название (Visa/Dankort и т.п.)
    val prepaid: Boolean?, // Признак предоплаченной карты
    val country: Country?, // Страна выпуска (вложенный объект Country)
    val bank: Bank?        // Банк-эмитент (вложенный объект Bank)
)

data class Country(
    val name: String?,      // Название страны (Denmark)
    val latitude: Int?,     // Географическая широта
    val longitude: Int?     // Географическая долгота
)

data class Bank(
    val name: String?,   // Название банка (Jyske Bank)
    val url: String?,    // Сайт банка
    val phone: String?,  // Телефон поддержки
    val city: String?    // Город
)