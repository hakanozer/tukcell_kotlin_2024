fun main() {
    println("Welcome to the Customer Management System!")

    val customerManager = CustomerManager()

    val regularCustomer = RegularCustomer("Bengisu Şahin", "bengisu@gmail.com",5555555555,10)
    val regularCustomer2 = RegularCustomer("Süleyman Bilirim", "Süleyman@gmail.com",5543566936,10)
    val vipCustomer = VIPCustomer("Bora Bilmem", "bora@gmail.com",3333333333,4)
    val vipCustomer2 = VIPCustomer("Türker Bilmem", "Türker@gmail.com",5546531543,8)

    customerManager.addCustomer(regularCustomer)
    customerManager.addCustomer(regularCustomer2)
    customerManager.addCustomer(vipCustomer)
    customerManager.addCustomer(vipCustomer2)

    println("\nCustomer List:")
    customerManager.listCustomers()

    customerManager.updateCustomer(3,"Boracan","boracan@hotmail.com", 5456366969)
    regularCustomer.loyaltyPoints = 5
    customerManager.updateCustomer(4,"Ben")

    println("\nCustomer List after update the customer:")
    customerManager.listCustomers()

    customerManager.removeCustomer(5)

    println("\nCustomer List after remove the customer:")
    customerManager.listCustomers()
}