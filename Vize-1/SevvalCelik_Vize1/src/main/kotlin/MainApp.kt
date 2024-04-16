import java.util.*

fun main() {

    //CustomerFactory ile müşteri oluşturma
    val regularCus1=CustomerFactory.regularCustomerOlustur("Şevval","sevvalc@gmail.com","1232644", UUID.randomUUID(),10)
    val regularCus2=CustomerFactory.regularCustomerOlustur("Elif","elif@gmail.com","35454", UUID.randomUUID(),200)
    val vipCus1=CustomerFactory.VIPCustomerOlustur("Rümeysa","rum@gmail.com","65655457", UUID.randomUUID(),3)
    val vipCus2=CustomerFactory.VIPCustomerOlustur("Aybüke","aybukeK3@gmail.com","444444", UUID.randomUUID(),1)

    // Regular müşteri oluşturma
    //val regularCustomer1 = RegularCustomer("Şevval", "sevvalcelik@gmail.com", "22222", UUID.randomUUID(), 10)

    // VIP müşteri oluşturma
    //val vipCustomer1 = VIPCustomer("Rümeysa", "rumeysaa@gmail.com", "6666666", UUID.randomUUID(), 3)

    val customerManager=CustomerManager()

    //müşteri ekleme
    customerManager.customerEkle(regularCus1)
    customerManager.customerEkle(regularCus2)
    customerManager.customerEkle(vipCus1)
    customerManager.customerEkle(vipCus2)

    //müşteri listeleme
    customerManager.customerListele()

    //müşteri güncelleme
    regularCus1.setLoyaltyLevel()
    regularCus2.setLoyaltyLevel()
    customerManager.updateCustomer(regularCus1.customerId, regularCus1)
    customerManager.updateCustomer(regularCus2.customerId, regularCus2)

    val regularCus1Guncelle=RegularCustomer("Şevval","guncellenmismail@gmail.com","4444444",regularCus1.customerId,80)
    customerManager.updateCustomer(regularCus1.customerId,regularCus1Guncelle)

    vipCus1.setVIPLevel(2)
    customerManager.updateCustomer(vipCus1.customerId, vipCus1)

    //güncellenmiş liste
    customerManager.customerListele()

    //müşteri silme
    customerManager.customerSilme(vipCus1.customerId)

    //güncel liste
    customerManager.customerListele()




}