fun main() {
    //Müşteri Giriş
    val regularCustomer = RegularCustomer ("Ömer Faruk", "ARSLAN", "omerfarukarslan355@gmail.com", "5512710720", 1, 350)
    val vipCustomer = VipCustomer ("Memduh Taha", "ARSLAN", "memduhtahaonline@gmail.com", "5512710720", 0, 20)

    //Müşteri yönetim ve müşteri ekleme
    val customerManager = CustomerManager ()
    customerManager.addCustomer(regularCustomer)
    customerManager.addCustomer(vipCustomer)

    //Müşteri listeleme
    customerManager.listCustomers()
    //Müşteri Güncelleme
    customerManager.updateCustomer(0, null, null, null, "memduhtaha35gunluk@gmail.com")

    //Müşteri Bulma
    println("===========================")
    customerManager.findCustomer(0)


}