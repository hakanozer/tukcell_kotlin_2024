//Bu kotlin dosyası Geleceği Yazanlar Kotlin 2024 Vize1 İçin Umut Yusuf Çınar tarafından oluşturuldu.
package org.example

//sınıfı Customer sınıfından türetiyorum
class RegularCustomer(
    name: String,
    surname: String,
    email: String,
    phoneNumber: String,
    customerId: String,
    //sınıfın kendine özgü özelliğini belirtiyorum
    var loyaltyPoints: Int
) : Customer(name, surname, email, phoneNumber, customerId) {

    override fun toString(): String {
        return "RegularCustomer(ad='$name', soyad='$surname', email='$email', telNo='$phoneNumber', müşteriId='$customerId', sadakatPuanı=$loyaltyPoints)"
    }
}
