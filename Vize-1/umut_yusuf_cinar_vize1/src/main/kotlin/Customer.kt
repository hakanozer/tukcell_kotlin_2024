//Bu kotlin dosyası Geleceği Yazanlar Kotlin 2024 Vize1 İçin Umut Yusuf Çınar tarafından oluşturuldu.
package org.example

abstract class Customer(
    var name: String,
    var surname: String,
    var email: String,
    var phoneNumber: String,
    var customerId: String
) {

    override fun toString(): String {
        return "Customer(ad='$name', soyad='$surname', email='$email', telNo='$phoneNumber', müşteriId='$customerId')"
    }
}
