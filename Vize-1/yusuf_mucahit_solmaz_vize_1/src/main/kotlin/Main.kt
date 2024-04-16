import java.util.*

fun main() {
    val customerManager = CustomerManagerImp()

    // Customer ekleme
    val yusuf = RegularCustomer("Yusuf", "yusuf@example.com", "123456789", UUID.randomUUID().toString(),100)
    val zeynep = VIPCustomer("Zeynep", "zeynep@example.com", "987654321", UUID.randomUUID().toString(),2)

    customerManager.addCustomer(yusuf)
    customerManager.addCustomer(zeynep)

    // Eklenen customer listeleme
    println("Initial customer list:")
    customerManager.listCustomers()

    // Customer ID'si alma
    println("\nGetting customer ID for Zeynep:")
    val zeynepId = customerManager.getCustomerId(zeynep)
    println("Zeynep's ID: $zeynepId")

    // Customer ID'sine göre müşteri getirme
    println("\nGetting customer by ID:")
    val retrievedCustomer = customerManager.getCustomerById(zeynep.customerId)
    println(retrievedCustomer)

    // Customer güncelleme
    println("\nUpdating customer Zeynep's email:")
    val updatedCustomer = VIPCustomer("Zeynep", "yenizeynep@example.com", "987654321",zeynep.customerId,5)
    customerManager.updateCustomer(zeynep.customerId, updatedCustomer)


    // Customer Derecesi Getirme
    println("\nGetting customer rank:")
    customerManager.getCustomerRank(yusuf)

    // Customer silme
    println("\nDeleting customer Yusuf:")
    customerManager.deleteCustomer(yusuf.customerId)

    println("\nFinal customer list as a result of transactions:")
    customerManager.listCustomers()
}

/*
    Output:

Initial customer list:
Customer ID: b13e21f8-4aa6-4134-900b-e1e548b0bcfd
Name: Yusuf
Email: yusuf@example.com
Phone: 123456789
-------------
Customer ID: 102a7ada-dea6-4c82-89b7-44c143477b89
Name: Zeynep
Email: zeynep@example.com
Phone: 987654321
-------------

Getting customer ID for Zeynep:
Zeynep's ID: 102a7ada-dea6-4c82-89b7-44c143477b89

Getting customer by ID:
Customer ID: 102a7ada-dea6-4c82-89b7-44c143477b89
Name: Zeynep
Email: zeynep@example.com
Phone: 987654321

Updating customer Zeynep's email:
Customer Updated

Getting customer rank:
Yusuf's Loyality Point: 100

Deleting customer Yusuf:
Customer with ID b13e21f8-4aa6-4134-900b-e1e548b0bcfd deleted.

Final customer list as a result of transactions:
Customer ID: 102a7ada-dea6-4c82-89b7-44c143477b89
Name: Zeynep
Email: yenizeynep@example.com
Phone: 987654321
-------------

*/