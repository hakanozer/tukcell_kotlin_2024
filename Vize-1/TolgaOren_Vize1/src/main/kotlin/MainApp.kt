fun main() {

    val customerManager = CustomerManager()
    val regularCustomer = RegularCustomer("Mehmet", "0456056516146", "mehmet@gmail.com")
    customerManager.addCustomer(regularCustomer)

    val vipCustomer = VIPCustomer("Hakan", "08762687682768", "hakan@gmail.com")
    customerManager.addCustomer(vipCustomer)

    println("-------------------------------")
    println( customerManager.getCustomers() )

    val vipCustomer2 = VIPCustomer("Ahmet", "21312313213213", "ahmet@gmail.com")
    customerManager.updateCustomer(vipCustomer, vipCustomer2)

    vipCustomer2.vipLevel = 25
    regularCustomer.loyaltyPoints = 50

    println("-------------------------------")
    println( customerManager.getCustomers() )

    customerManager.removeCustomer(vipCustomer2)

    println("-------------------------------")
    println( customerManager.getCustomers() )

}