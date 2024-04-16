package org.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter

// Cinsiyet için enum sınıfı
enum class Gender {
    ERKEK,
    KADIN,
    DIGER
}

// Dil için enum sınıfı
enum class Language {
    INGILIZCE,
    ISPANYOLCA,
    FRANSIZCA,
    ALMANCA,
    TURKCE,
    DIGER
}

//hobi için enum sınıfı
enum class Hobby {
    SPOR,
    MUZIK,
    GEZI,
    OKUMA,
    YEMEK,
    DIGER
}

// Soyut Customer sınıfı
abstract class Customer(
    val name: String,
    var email: String,
    var phoneNumber: String,
    val address: String,
    val idNumber: String,
    val birthDate: LocalDate,
    val gender: Gender,
    val language: Language,
    val hobby: Hobby
) {
    abstract val customerId: String
    abstract val loyaltyPoints: Int

    override fun toString(): String {
        val formattedBirthDate = birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        return """
            Musteri ID: $customerId
            Isım: $name
            Email: $email
            Telefon Numarasi: $phoneNumber
            Adres: $address
            ID Numarasi: $idNumber
            Dogum Tarihi: $formattedBirthDate
            Cinsiyet: $gender
            Dil: $language
            Hobi: $hobby
            Sadakat Puanı: $loyaltyPoints
        """.trimIndent()
    }
}