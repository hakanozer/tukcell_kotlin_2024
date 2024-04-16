fun main() {

    val customer1 = RegularCustomer("Selin", "selincengiz41@gmail.com", "23123213", 43)
    val customer2 = VIPCustomer("Nalan", "nalan@gmail.com", "324142", 5)

    val customerManager = CustomerManager()

    customerManager.addCustomer(customer1)
    customerManager.addCustomer(customer2)

    customerManager.listCustomers()

    customerManager.removeCustomer(1)

    customerManager.listCustomers()

    customerManager.updateCustomer(2, name = "Ayten", email = "ayten@gmail.com", pointLevel = 5)

    customerManager.listCustomers()
}