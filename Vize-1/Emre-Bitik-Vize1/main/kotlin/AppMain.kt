fun main() {

    val customerManager = CustomerManager()

    // Sadakat müşterisi ekleme
    customerManager.addRegularCustomer("101","Ahmet DEMİR", "ahmetdmr@mail.com", "5321654987", 100)
    customerManager.addRegularCustomer("103","Mehmet KAL", "mehmetkal@mail.com", "111111111", 15)
    //customerManager.addRegularCustomer("Mehmet DEMİR", "mehmet.dmr@mail.com", "5321784987", 100)

    // Vip müşterisi ekleme
    customerManager.addVIPCustomer("102","Ela KAÇMAZ", "elak54@mail.com", "56666458", 3)
    customerManager.addVIPCustomer("104","Ayşe KILIÇ", "ayseklc123@mail.com", "22354126", 10)

    // Sadakat müşterisi güncelleme güncelleme
    val updatedRegularCustomer = RegularCustomer("101","Ahmet DEMİR", "ahmetdmr@mail.com", "5321654987", 95)
    customerManager.updateCustomer(updatedRegularCustomer.customerId, updatedRegularCustomer)

    // Vip müşteri güncelleme
    val updatedVIPCustomer = VIPCustomer("102","Ela KAÇMAZ", "elak54@mail.com", "56666458", 4)
    customerManager.updateCustomer(updatedVIPCustomer.customerId, updatedVIPCustomer)

   //Müşteri Listeleme
    customerManager.listCustomers()
}
