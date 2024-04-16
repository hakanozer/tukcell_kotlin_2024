fun main() {

    val customerManager = CustomerManager()

    // Müşteri ekleme

    customerManager.addCustomer(VIPCustomer(1, "Ahmet", "info@ahmet.com", "05374561223", "İstanbul", "Gold"))
    customerManager.addCustomer(RegularCustomer(2, "Mehmet", "info@mehmet.com", "05387895676", "Ankara", 130))
    customerManager.addCustomer(VIPCustomer(3, "Fatih", "info@fatih.com", "05533431907", "Eskişehir", "Premium"))
    customerManager.addCustomer(RegularCustomer(4, "Ekrem", "info@ekrem.com", "05412347889", "İzmir", 200))
    customerManager.addCustomer(VIPCustomer(5, "Zehra", "info@zehra.com", "05435673563", "Elazığ", "Diamond"))
    customerManager.addCustomer(RegularCustomer(6, "Hatice", "info@hatice.com", "05352827559", "Tekirdağ", 500))

    // Müşteri Listeleme
    customerManager.listCustomer()

    println("============================================================")

    //Müşteri Güncelleme

    customerManager.updateCustomer(4,"Caner", "info@caner.com", null,null)
    customerManager.updateCustomer(7, null,null, null, null)

    println("================================================================")
    customerManager.listCustomer()

    // Müşteri Kaldırma
    println("=================================================================")
    customerManager.removeCustomer(5)
    customerManager.listCustomer()
    println("=====================================================================")
    customerManager.removeCustomer(5)
    customerManager.listCustomer()
}
