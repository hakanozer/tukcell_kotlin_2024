package org.example

import java.time.LocalDate

//RegularCustomer sınıfı
class RegularCustomer(
    name: String,
    email: String,
    phoneNumber: String,
    address: String,
    idNumber: String,
    birthDate: LocalDate,
    gender: Gender,
    language: Language,
    hobby: Hobby,
    override val loyaltyPoints: Int
) : Customer(name, email, phoneNumber, address, idNumber, birthDate, gender, language, hobby) {
    override val customerId: String = "REG-${name.hashCode()}"
}
