fun main() {
    // 3 tane regular customer ve 2 tane vip customer oluşturalım.

    val customer = RegularCustomer("rc1", "ahmet", "ahmet@gmail.com", "0545 555 55 55","Bursa", 5)
    val customer2 = VIPCustomer("vipc1", "ceren", "ceren@gmail.com", "0545 666 55 66", "İstanbul",1)
    val customer3 = RegularCustomer("rc2", "yavuz", "yavuz@gmail.com", "0534 888 55 55","Mersin", 8)
    val customer4 = RegularCustomer("rc3", "hilal", "hilal@email.com", "0545 777 55 55", "Balıkesir",2)
    val customer5 = VIPCustomer("vipc2", "fatih", "fatih@gmail.com", "0545 999 55 55", "Ankara",5)

    //  customer5 ile aynı id değeri verilip hata mesajı yazdırma
    val customer6 = VIPCustomer("vipc2", "mehmet", "mehmet@gmail.com", "0545 333 55 55","Kahramanmaraş", 5)

    // customerleri yönetmek için CustomerManager oluşturma ve müşterilerin eklenmesi
    val customerManager = CustomerManager()

    println("\n***customer manager ---> customer ekleme işlemi")
    customerManager.addCustomer(customer)
    customerManager.addCustomer(customer2)
    customerManager.addCustomer(customer3)
    customerManager.addCustomer(customer4)
    customerManager.addCustomer(customer5)
    customerManager.addCustomer(customer6) // aynı ID'li customer


    // list all customers
    println("\n***customer manager ---> bütün müşterileri listeleme")
    customerManager.listCustomers()

    // Müşteri güncelleme
    println("\n***customer manager ---> rc2 ID'li customeri güncelleme işlemi")
    customerManager.updateCustomer("rc2", RegularCustomer("rc2", "Vural", "vural@gmail.com", "0545 222 22 22", "Kahramanmaraş",8))

    println("\n***customer manager ---> yanlış ID'li customeri güncelleme işlemi")
    customerManager.updateCustomer("rc22", RegularCustomer("rc2", "Vural", "vural@gmail.com", "0545 222 22 22", "Kahramanmaraş",8))

    println("\n***customer manager ---> rc2 ID'li customer bilgileri")
    customerManager.showCustomerById("rc2")

    // Müşteri silme
    println("\n***customer manager ---> vipc2 ID'li customeri silme işlemi")
    customerManager.removeCustomerById("vipc2")

    println("\n***customer manager ---> yanlış ID'li customeri silme işlemi")
    customerManager.removeCustomerById("vipc22")

    // müşteri silindikten sonraki güncellenmiş liste
    println("\n***customer manager ---> bütün müşterileri listeleme")
    customerManager.listCustomers()

    println("\n***customer ---> sadakat puanı öğrenme")
    customer.getLoyaltyPoints()

}