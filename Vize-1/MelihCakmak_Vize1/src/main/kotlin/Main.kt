
fun main() {
    val customerManager=CustomerManager()



    val regularCustomer = RegularCustomer("regular1", "reg1@example.com", "123456789",  100)
    val regularCustomer2 = RegularCustomer("regular2", "reg2@example.com", "123456789",  100)
    val regularCustomer3 = RegularCustomer("regular3", "reg3@example.com", "123456789",  100)
    val regularCustomer4 = RegularCustomer("regular4", "reg4@example.com", "123456789",  100)
    val vipCustomer=VipCustomer("Vip1", "vip1@example.com", "123456789",  1)
    val vipCustomer2=VipCustomer("Vip2", "vip2@example.com", "123456789",  2)
    val vipCustomer3=VipCustomer("Vip3", "vip3@example.com", "123456789",  4)



    customerManager.addCustomer(regularCustomer)
    customerManager.addCustomer(regularCustomer2)
    customerManager.addCustomer(regularCustomer3)
    customerManager.addCustomer(regularCustomer4)
    customerManager.addCustomer(vipCustomer)
    customerManager.addCustomer(vipCustomer2)
    customerManager.addCustomer(vipCustomer3)

    customerManager.regularToVip(regularCustomer4)

    customerManager.removeCustomer(regularCustomer2)
    customerManager.increaseLoyaltyPoints(regularCustomer3)
    customerManager.increaseVipLevel(vipCustomer2)
    customerManager.updateCustomer(regularCustomer3,newName = "New Regular Customer3")

    customerManager.listCustomers()







}