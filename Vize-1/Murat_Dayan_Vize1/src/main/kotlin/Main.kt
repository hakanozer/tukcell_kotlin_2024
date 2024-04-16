fun main() {


    val customerManager = CustomerManager()

    val Mecnun =customerManager.addCustomer(
        "1",
        "Mecnun",
        "Mecnun@test.com",
        "0534754854",
    )
    val Leyla =customerManager.addCustomer(
        "2",
        "Leyla",
        "Leyla@test.com",
        "353465234",
    )
    val Erdal =customerManager.addCustomer(
        "3",
        "Erdal",
        "Erdal@test.com",
        "442365243",
    )

    println(Mecnun)

    println("------------------------------------------------------------------------------")
    customerManager.increaseLoyaltyPoint(Mecnun.customerId,75)
    println(Mecnun)

    println("------------------------------------------------------------------------------")
    customerManager.updateCustomer(Mecnun.customerId,"Yeni Mecnun",Mecnun.customerEMail,Mecnun.customerPhone)

    val primeMecnun = customerManager.becomeVipCostumer(Mecnun.customerId)

    println(primeMecnun)

    customerManager.increaseLoyaltyPoint(Mecnun.customerId,50)
    if (Mecnun.customerLoyaltyPoints!! >= 100){
        customerManager.increaseVipLevel(Mecnun.customerId,2)
    }

    println(primeMecnun)

    println("------------------------------------------------------------------------------")
    customerManager.removeCustomer(Erdal.customerId)

    println("------------------------------------------------------------------------------")
    println("Tüm Müşteriler")
    customerManager.customerList.forEach {
        println(it.customerName)
    }




}