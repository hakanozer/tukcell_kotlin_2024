fun main() {
    val customerManager = CustomerManager()

    val customer1 = customerManager.createCustomer(0,
        "Cevdet KILIÇKESER",
        "cevdetkilickeser@hotmail.com",
        "05355353535")


    val customer2 = customerManager.createCustomer(1,
        "Ayşe YILMAZ",
        "ayseyilmaz@hotmail.com",
        "05555555555")

    val customer3 = customerManager.createCustomer(0,
        "Mehmet ÇELİK",
        "mehmetcelik@hotmail.com",
        "05455454545")

    val customer4 = customerManager.createCustomer(1,
        "Fatma ATEŞ",
        "fatmaates@hotmail.com",
        "05365363636")

    customerManager.addCustomer(customer1)
    customerManager.addCustomer(customer2)
    customerManager.addCustomer(customer3)
    customerManager.addCustomer(customer4)

    customerManager.listCustomers()

    customerManager.increaseVipOrLoyaltyPoint(customer1,3)
    customerManager.increaseVipOrLoyaltyPoint(customer2,5)
    customerManager.updateCustomer(customer3,"","","05305303030")

    customerManager.listCustomers()

    customerManager.removeCustomer(customer3)
    customerManager.decreaseVipOrLoyaltyPoint(customer1,1)
    customerManager.decreaseVipOrLoyaltyPoint(customer2,3)

    customerManager.listCustomers()
}