import java.util.UUID

fun main() {

    val customer = RegularCustomer("Ali", "ali@example.com", "+12 123-456-789",UUID.randomUUID().toString(),4)
    val customer2 = VIPCustomer("Mehmet", "mehmet@example.com", "+53 123-56-7890", UUID.randomUUID().toString(),3)
    val customer3 = VIPCustomer("Ayla", "ayla@example.com", "+90 123-456-79", UUID.randomUUID().toString(),9)

    val manager = CustomerManager()
    manager.addCustomer(customer)
    manager.addCustomer(customer2)
    manager.addCustomer(customer3)


    val customerList = manager.listCustomers()
    println(customerList)

    println("------------------------------------------------------------------------------------------------------")

    manager.updateCustomer(customer.customerId,"Veli","veli@example.com","123456")
    println(customerList)





}