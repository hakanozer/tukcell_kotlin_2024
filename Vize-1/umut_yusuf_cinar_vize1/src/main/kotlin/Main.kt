//Bu kotlin dosyası Geleceği Yazanlar Kotlin 2024 Vize1 İçin Umut Yusuf Çınar tarafından oluşturuldu.
package org.example

fun main() {
    //örnek müşterileri tanımlıyorum
    val customer1 = RegularCustomer(name = "Umut Yusuf", surname = "Çınar", email = "umut.yusuf.cinar.mail@gmail.com", phoneNumber = "5554443322", customerId = "C001", loyaltyPoints = 100)
    val customer2 = VIPCustomer(name = "Elifnaz", surname = "Çınar", email = "elifnaz@gmail.com", phoneNumber = "5556665544", customerId = "C002", vipLevel = "Altın Üye")
    val customer3 = RegularCustomer(name = "Mustafa", surname = "Çınar", email = "mustafa@gmail.com", phoneNumber = "5557776665544", customerId = "C003", loyaltyPoints = 50)
    val customer4 = RegularCustomer(name = "Dominik", surname = "Livakoviç", email = "muthiskaleci@gmail.com", phoneNumber = "1111112233", customerId = "C004", loyaltyPoints = 100)
    val customerManager = CustomerManager()

    //bu müşterileri ekliyorum
    customerManager.addCustomer(customer1)
    customerManager.addCustomer(customer2)
    customerManager.addCustomer(customer3)
    customerManager.addCustomer(customer4)

    //eklediklerimi listeliyorum
    customerManager.listCustomers()

    //kullanıcıyı güncelliyorum
    customerManager.updateCustomer("C004", RegularCustomer(name = "Dusan", surname = "Tadic", email = "muthis10numara@gmail.com", phoneNumber = "5554443322", customerId = "C004", loyaltyPoints = 100))
    //güncellenen kullanıcıdan sonra tekrardan listeleme yapıyorum
    customerManager.listCustomers()
}
