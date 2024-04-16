//Bu kotlin dosyası Geleceği Yazanlar Kotlin 2024 Vize1 İçin Umut Yusuf Çınar tarafından oluşturuldu.
package org.example
//sınıfı Customer sınıfından türetiyorum
class VIPCustomer(
    name: String,
    surname: String,
    email: String,
    customerId: String,
    phoneNumber: String,
    //sınıfın kendine özgü özelliğini belirtiyorum
    var vipLevel: String
) : Customer(email, name, surname, customerId, phoneNumber) {

    override fun toString(): String {
        return "VIPCustomer(ad='$name', soyad='$surname', email='$email', telNo='$phoneNumber', müşteriId='$customerId', vipLeveli='$vipLevel')"
    }
}
