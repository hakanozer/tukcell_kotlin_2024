fun main() {
    val regularCustomer1 = RegularCustomer("Taha Gökpınar", "gokpinartaha@gmail.com", 123456789, "REG1", 100)
    val vipCustomer1 = VipCustomer("Furkan Kaya", "furkankaya@gmail.com", 987654321, "VIP1", 2)
    val regularCustomer2 = RegularCustomer("Berkay Keskin", "berkaykeskn@gmail.com", 43404304, "REG2",50)
    val vipCustomer2 = VipCustomer("Ali Aslan", "aliaslan@outlook.com", 430225466,"VIP2",4)
    val vipCustomerChanged = VipCustomer("Taha Gökpınar", "tahagkpnr@gmail.com",987654321,"VIP1", 3)

    val customers = CustomerManager()

    customers.addCustomer(regularCustomer1)
    customers.addCustomer(vipCustomer1)
    customers.addCustomer(regularCustomer2)
    customers.addCustomer(vipCustomer2)

    //customers.updateCustomer("REG001", vipCustomerChanged)
    customers.updateCustomer("VIP1", vipCustomerChanged)

    //customers.removeCustomer("VIP001")

    customers.listCustomers()

}