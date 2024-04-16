package org.example

import java.time.LocalDate
import java.time.format.DateTimeFormatter

//VIPCustomer sınıfı
class VIPCustomer(
    name: String,
    email: String,
    phoneNumber: String,
    address: String,
    idNumber: String,
    birthDate: LocalDate,
    gender: Gender,
    language: Language,
    hobby: Hobby,
    override val loyaltyPoints: Int,
    private val vipLevel: Int
) : Customer(name, email, phoneNumber, address, idNumber, birthDate, gender, language, hobby) {
    override val customerId: String = "VIP-${name.hashCode()}"

    override fun toString(): String {
        val formattedBirthDate = birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
        return """
            ${super.toString()}
            VIP Leveli: $vipLevel
        """.trimIndent()
    }
}