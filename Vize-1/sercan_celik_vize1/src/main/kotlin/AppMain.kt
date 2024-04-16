fun main() {
    val customerManager = CustomerManager()
    //VİP müşterileri ekleme
    val vipCustomer1 = VIPCustomer(3, "Sercan", "sercanxcelik@gmail.com", "05055551111", 1)
    val vipCustomer2 = VIPCustomer(1, "Zehra", "zehra896798@gmail.com", "05055551112", 2)
    val vipCustomer3 = VIPCustomer(5, "Merve", "merve78632@gmail.com", "05055551113", 3)

    customerManager.addCustomer(vipCustomer1)
    customerManager.addCustomer(vipCustomer2)
    customerManager.addCustomer(vipCustomer3)

    //Regular müşterileri ekleme
    val regularCustomer1 = RegularCustomer(25, "Ali", "ali3243@gmail.com", "05055551114", 4)
    //Aynı ID numarası ile kayıt yapan kullanıcı ekleme (regularCustomer2 ve regularCustomer5- (Aynısı VİP customerler için de geçerli))
    val regularCustomer2 = RegularCustomer(25, "Can", "can9869876@gmail.com", "05055551114", 4)
    val regularCustomer3 = RegularCustomer(65, "Kerem", "kerem76587@outlook.com", "05051771515", 5)
    val regularCustomer4 = RegularCustomer(85, "Nazlı", "nazlican7@gmail.com", "05011778516", 6)
    //Aynı Telefon numarası ile kayıt yapan kullanıcı ekleme (regularCustomer3 ve regularCustomer5)
    val regularCustomer5 = RegularCustomer(101, "Nazlı", "nazlican7@gmail.com", "05051771515", 7)

    customerManager.addCustomer(regularCustomer1)
    customerManager.addCustomer(regularCustomer2)
    customerManager.addCustomer(regularCustomer3)
    customerManager.addCustomer(regularCustomer4)
    customerManager.addCustomer(regularCustomer5)

    //VİP müşteri güncelleme - 1 Numaralı ID' ye ait müşterinin telefon numarası güncellendi.
    val updatedVIPCustomer = VIPCustomer(4, "Sercan", "sercanxcelik@gmail.com", "05445445454", 1)
    customerManager.updateCustomer(updatedVIPCustomer, 1)

    //Regular müşteri güncelleme - 4 Numaralı ID' ye ait müşterinin isim güncellendi.
    val updatedRegularCustomer = RegularCustomer(25, "Alican", "ali3243@gmail.com", "05055551114", 4)
    customerManager.updateCustomer(updatedRegularCustomer,4)

    //Müşteri silme
    customerManager.removeCustomer(6)

    //Güncel Müşteri Listesi
    customerManager.listCustomers()
}