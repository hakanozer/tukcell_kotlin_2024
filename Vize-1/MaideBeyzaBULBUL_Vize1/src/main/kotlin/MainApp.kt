fun main() {
    val manager = CustomerManager()

    val regularCustomer = RegularCustomer("Maide Beyza BÜLBÜL", "maidebeyzabulbul@gmail.com", "1234567890", 100)
    val vipCustomer = VIPCustomer("Oğuzhan YILDIRIM", "oguzhanyildirim@gmail.com", "0987654321", 2)

    manager.addCustomer(regularCustomer)
    manager.addCustomer(vipCustomer)

    manager.calculateVipPointsForAll()
    manager.calculateLoyaltyPointsForAll()

    manager.listCustomers() // Müşteri bilgilerini listeleme işlemi
}