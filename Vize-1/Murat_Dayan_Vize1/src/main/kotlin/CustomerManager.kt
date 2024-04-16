class CustomerManager : ICustomer {

    val customerList = mutableListOf<Customer>()

    override fun addCustomer(
        customerId: String,
        customerName: String,
        customerEMail: String,
        customerPhone: String,
    ): Customer {
        val regularCustomer =
            RegularCustomer(customerId, customerName, customerEMail, customerPhone)

        customerList.add(regularCustomer)
        return regularCustomer
    }

    override fun updateCustomer(
        customerId: String,
        customerName: String,
        customerEMail: String,
        customerPhone: String
    ): Customer? {

        val customerIndex = customerList.indexOfFirst { it.customerId == customerId }

        if (customerIndex != -1) {
            val customer = customerList[customerIndex]
            customer.customerName = customerName
            customer.customerEMail = customerEMail
            customer.customerPhone = customerPhone
            return customer
        } else {
            return null
        }
    }

    override fun becomeVipCostumer(customerId: String): VIPCustomer? {
        val customerIndex = customerList.indexOfFirst { it.customerId == customerId }

        if (customerIndex != -1) {
            val customer = customerList[customerIndex]

            if (customer is Customer) {
                if (customer.customerLoyaltyPoints ?: 0 >= 50) {
                    val newVipLevel = (customer.customerVipLevel ?: 0) + 1
                    println("Müşteri VIP olabilir.")
                    println("Eski VIP Seviyesi: ${customer.customerVipLevel}")
                    println("Yeni VIP Seviyesi: $newVipLevel")
                    val newVipCustomer = VIPCustomer(
                        customerId,
                        customer.customerName,
                        customer.customerEMail,
                        customer.customerPhone,
                        newVipLevel
                    )
                    customerList.removeAt(customerIndex)
                    customerList.add(newVipCustomer)
                    increaseVipLevel(customerId,1)
                    return newVipCustomer
                } else {
                    println("Müşterinin sadakat puanı 50'den az olduğu için VIP olamaz.")
                }
            } else {
                println("Müşteri Customer sınıfından değil.")
            }
        } else {
            println("Müşteri bulunamadı.")
        }
        return null
    }

    override fun increaseLoyaltyPoint(customerId: String, pointsToAdd: Int) {
        val customerIndex = customerList.indexOfFirst { it.customerId == customerId }
        val customer = customerList.find { it.customerId == customerId }
        customer?.apply {
            if (customerLoyaltyPoints == null) {
                customerLoyaltyPoints = pointsToAdd
            } else {
                customerLoyaltyPoints = customerLoyaltyPoints!! + pointsToAdd
            }
        }
        customerList.removeAt(customerIndex)
        customer?.let {
            customerList.add(it)
        }

    }

    override fun removeCustomer(customerId: String) {
        val customerIndex = customerList.indexOfFirst { it.customerId == customerId }
        if (customerIndex != -1) {
            customerList.removeAt(customerIndex)
            println("Müşteri başarıyla silindi.")
        } else {
            println("Müşteri bulunamadı.")
        }
    }

    override fun increaseVipLevel(customerId: String, targetLevel: Int) {
        val customer = customerList.find { it.customerId == customerId }
        if (customer is Customer) {
            val currentVipLevel = customer.customerVipLevel ?: 0
            customer.customerVipLevel = currentVipLevel + targetLevel
            println("Müşterinin VIP seviyesi başarıyla artırıldı. Yeni VIP Seviyesi: ${customer.customerVipLevel}")
        } else {
            println("Müşteri bulunamadı veya VIP müşteri değil.")
        }
    }


}