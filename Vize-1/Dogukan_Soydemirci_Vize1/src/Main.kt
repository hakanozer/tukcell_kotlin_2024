fun main() {

    val customerManager = CustomerManager()
    val regularCustomer1 = RegularCustomer("Hans", "hans@gmail.com", "44567312212", 20)
    val regularCustomer2 = RegularCustomer("Bloom", "bloom@gmail.com", "304829222", 30)
    val vipCustomer1 = VIPCustomer("Alina", "alina@gmail.com", "66543322112", 1)
    val vipCustomer2 = VIPCustomer("Danny", "danny@gmail.com", "784655511", 2)


    customerManager.addCustomer(regularCustomer1)
    customerManager.addCustomer(regularCustomer2)
    customerManager.addCustomer(vipCustomer1)
    customerManager.addCustomer(vipCustomer2)


    customerManager.listAllCustomers()


    val updatedVipCustomer = VIPCustomer("Chris", "chris@gmail.com", "1123449595", 50)
    customerManager.updateCustomer(vipCustomer2.customerId,updatedVipCustomer)
    println("\n************  ${vipCustomer2.customerId} UPDATED  to  ${updatedVipCustomer.customerId} ************\n")

    customerManager.listAllCustomers()


}