fun main() {
    val customerManager = CustomerManager()
    val customer1 = RegularCustomer(1,"Emre Cura", "emre@example.com", "1234567890" )
    val customer2 = VIPCustomer(2,"Ahmet Sinan", "sinan@example.com", "0987654321" )
    val customer3 = RegularCustomer(3,"Emre Cura", "emre@example.com", "1234567890" )
    val customer4 = VIPCustomer(4,"Ahmet Sinan", "sinan@example.com", "0987654321" )
    customerManager.addCustomer(customer1)
    customerManager.addCustomer(customer2)
    customerManager.addCustomer(customer3)
    customerManager.addCustomer(customer4)

    //toString
    println("*************toString*************")
    println(customer1.toString())
    println(customer2.toString())

    println("*************Loyalty points and VIP Levels*************")
    customerManager.increaseSpecialFuture(customer1)
    customerManager.increaseSpecialFuture(customer1)
    customerManager.increaseSpecialFuture(customer3)
    customerManager.increaseSpecialFuture(customer2)
    customerManager.increaseSpecialFuture(customer2)
    customerManager.decreaseSpecialFuture(customer2)
    println(customerManager.listCustomers())

    println("*************Remove a customer*************")
    customerManager.removeCustomer(customer4.customerId)
    println(customerManager.listCustomers())

    println("*************Update a customer*************")
    customerManager.updateCustomer(3,"Ayşe", "ayse@example.com", "4563167890")
    println(customerManager.listCustomers())

    println("*************Convert a customer to Regular*************") //or convert to vip
    customerManager.decreaseSpecialFuture(customer2)
    customerManager.decreaseSpecialFuture(customer2)
    customerManager.increaseSpecialFuture(customer1)
    customerManager.increaseSpecialFuture(customer1)
    customerManager.increaseSpecialFuture(customer1)

    println(customerManager.listCustomers())



}