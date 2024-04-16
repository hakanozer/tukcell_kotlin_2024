fun main() {
    /// Factory nesnemizi oluşturuyoruz
    var customerManager = CustomerManager()

    /// Abone bilgilerini giriyoruz
    var vipCustomer1 = VIPCustomer(customerId = "11",name = "Eray"  , email = "Eray@mail.com" , phoneNumber = 5377633052 )
    var vipCustomer2 = VIPCustomer(customerId = "12",name = "Gökçen"  , email = "Gökçen@mail.com" , phoneNumber = 5632568254 )
    var vipCustomer3 = VIPCustomer(customerId = "13",name = "Koray"  , email = "Koray@mail.com" , phoneNumber = 5365742564 )
    var regularCustomer1 = RegularCustomer(customerId = "14", name = "İltan"  , email = "İltan@mail.com" , phoneNumber = 5347852457 )
    var regularCustomer2 = RegularCustomer(customerId = "15",name = "Nesrin"  , email = "Nesrin@mail.com" , phoneNumber = 5368542585 )
    var regularCustomer3 = RegularCustomer(customerId = "16",name = "Ahmet"  , email = "Ahmet@mail.com" , phoneNumber = 5376523459 )
    var regularCustomer4 = RegularCustomer(customerId = "17",name = "123"  , email = "Ahmet@mail.com" , phoneNumber = 5376523459 )

    /// Abone ekleme , çıkarma , güncelleme ve listeleme işlemleri Factory classımız tarafından çalıştırılıyor

    customerManager.addCustomer(vipCustomer1)
    customerManager.addCustomer(vipCustomer1) /// Ekleme başarısız
    customerManager.addCustomer(vipCustomer2)
    customerManager.addCustomer(vipCustomer3)
    customerManager.addCustomer(regularCustomer1)
    customerManager.addCustomer(regularCustomer2)
    customerManager.addCustomer(regularCustomer3)
    customerManager.addCustomer(regularCustomer4)


    println("======================================")

    customerManager.removeCustomer(vipCustomer3)
    customerManager.removeCustomer(regularCustomer3)
    customerManager.removeCustomer(regularCustomer4)

    println("======================================")

    customerManager.updateCustomerInfo( "10" , "Eray Başarısız") /// Güncelleme başarısız
    customerManager.updateCustomerInfo( "11" , "Eray A")


    println("======================================")


    customerManager.listCustomers()

    regularCustomer1.loyaltyPoints = 10
    regularCustomer1.showLoyaltyPoints()
    vipCustomer1.vipLevel = 1
    vipCustomer1.showVIPLevel()

}