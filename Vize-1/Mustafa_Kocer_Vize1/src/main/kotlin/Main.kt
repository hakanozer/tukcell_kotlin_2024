import org.example.Customer


fun main() {
 /*
    val customer1 = Customer("John Doe", "john@example.com", "555-1234")
    val customer2 = Customer("Jane Smith", "jane@example.com", "555-5678")
    val customer3 = Customer("Jane Smith", "jane@example.com", "555-5678")


    println(customer1)
    println(customer2)

  */
    // Örnek RegularCustomer ve VIPCustomer nesneleri oluşturulur

    val c1 = VIPCustomer("Thomas Shelby", "thomas@example.com", "+1234567890")
    val c2 = RegularCustomer("Arthur Shelby", "arthur@example.com", "+1987654321")
    val c3 = VIPCustomer("Polly Gray", "polly@example.com", "+1122334455")
    val c4 = RegularCustomer("John Shelby", "john@example.com", "+1567890123")
    val c5 = VIPCustomer("Michael Gray", "michael@example.com", "+1456321879")
    val c6 = RegularCustomer("Alfie Solomons", "alfie@example.com", "+1654321890")
    val c7 = VIPCustomer("Ada Shelby", "ada@example.com", "+1789456321")
    val c8 = RegularCustomer("Finn Shelby", "finn@example.com", "+1876543210")
    val c9 = VIPCustomer("Grace Burgess", "grace@example.com", "+1543217890")
    val c10 =RegularCustomer("Aberama Gold", "aberama@example.com", "+1325476980")

    val manager = CustomerManager()

    manager.addCustomer(c1)
    manager.addCustomer(c2)
    manager.addCustomer(c3)
    manager.addCustomer(c4)
    manager.addCustomer(c5)
    manager.addCustomer(c6)
    manager.addCustomer(c7)
    manager.addCustomer(c8)
    manager.addCustomer(c9)
    manager.addCustomer(c10)

    println("----------------Herhangi bir islem yapilmadan once liste------------------")
    manager.listCustomers()
    println("-----------------------------------------------------------------------\n\n")


    println("----------------İşlemler yapıldıktan sonra liste------------------")

    manager.addCustomer(c1)
    // 2 kere eklemeyecek, çünkü set ile tutuyorum
    manager.addCustomer(c2)
    manager.updateCustomerName(c3,"Poli hala")
    manager.updateCustomerPhone(c4, "+111111")
    manager.updateCustomerEMail(c5, "mgray@example.com")

    manager.addCustomer(c3)
    // değişiklik yaptığım müşteriyi tekrar eklemeye çalışıyorum, set ile tuttuğum için eklemiyor

    manager.updateVIPLevel(c6, 12)
    manager.updateVIPLevel(c7, 12)
    manager.updateLoyaltyPoint(c8,17)
    manager.updateLoyaltyPoint(c9, 17)
    // vip müşteri olmasına rağmen loyaltypoints fonksiyonu çağrıldığında hata vermiyor çünkü fonksiyonda kontrol ediyorum
    manager.removeCustomer(c10)
    manager.removeCustomer(c10)

    manager.listCustomers()



}