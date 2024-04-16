package org.example

fun main() {
    // Bütün müşterileri yönetebildiğimiz Customer Manager nesnesi
    val customerManager = CustomerManager()

    // Regular Customer ve Vip Customer sınıflarına ait nesneler
    val regularCustomer = RegularCustomer(0, "Mehmet", "mehmet@gmail.com", "1111")
    val regularCustomer2 = RegularCustomer(0, "Ali", "ali@gmail.com", "2222")
    val vipCustomer = VipCustomer(3, "Veli", "veli@gmail.com", "3333")
    val vipCustomer2 = VipCustomer(2, "Omer", "omer@gmail.com", "4444")
    val vipCustomer3 = VipCustomer(4, "Ufuk", "ufuk@gmail.com", "5555")

    // Üstte oluşturulan müşterileri sisteme ekliyoruz.
    customerManager.addCustomer(regularCustomer, regularCustomer2, vipCustomer, vipCustomer2, vipCustomer3)

    // Sistemde var olan bütün müşterileri getirir.
    customerManager.listAllCustomer()

    println(vipCustomer.toString()) // Vip Customer'a ait bilgiler
    println() // Düzenli durması için boş satır.
    println(regularCustomer.toString()) // Regular Customer'a ait bilgiler.
    println()

    // Müşteri bilgilerini güncelliyoruz. Değişmesini istemediğimiz parametrelere null verebiliriz. Sadece telefon no değiştirildi.
    customerManager.updateCustomerInfo(regularCustomer, null, null, "8888")
    println("Updated Customer Info:")
    println(regularCustomer.toString()) // Güncellenen telefon numarasını görebiliriz.
    println()

    // Vip müşteriye vip seviyesine göre indirim uygulandı (vip level = 3 olduğu için %30 uygulandı).
    vipCustomer.discountBasedOnVIPLevel()
    println()

    // Regular müşteri eğer ürün alırsa, aldığı ürüne göre sadakat puanı kazanıyor. (Bu fiyata göre 350 puan kazandı)
    regularCustomer.buyProduct(455)
    println()

    // İki tane müşteriyi sistemimizden çıkardık. (id'si 1 ve 5 olanları)
    customerManager.removeCustomer(0,5,6)
    customerManager.listAllCustomer() // 3 tane müşteri kaldı

    // Bütün müşterileri sistemden sildik.
    customerManager.clearCustomerList()
    customerManager.listAllCustomer() // Boş liste döner.
}