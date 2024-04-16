package org.example

class CustomerManager {
    // Bütün müşterilerin tutulduğu liste.
    private var customerList = mutableListOf<Customer>()

    // vararg yapısı ile istediğimiz kadar customer ekleyebiliriz.
    fun addCustomer(vararg customer: Customer) {
        customer.forEach { customerElement ->
            customerList.add(customerElement)
        }
    }

    // vararg yapısı ile istediğimiz kadar customer çıkartabiliriz.
    fun removeCustomer(vararg customerId: Int) {
        // Sadece verilen id sistemde var ise o müşteriyi silecek.
        customerId.forEach { customerIdElement ->
            val findCustomer = customerList.find { customer ->
                customer.customerId == customerIdElement
            }
            customerList.remove(findCustomer)
        }
    }

    fun updateCustomerInfo(
        updateCustomer: Customer,
        newCustomerName: String?,
        newCustomerEmail: String?,
        newCustomerTelNo: String?,
    ) {
        // Güncellenecek müşteriyi buluyoruz.
        val findCustomer = customerList.find { customer ->
            customer.customerId == updateCustomer.customerId
        }

        // Müşteri bilgilerini güncelliyoruz. Scope fonksiyon kullanarak sürekli findCustomer yazımını azalttım.
        // Null ifade verilebilir bu sayede eski değerlerini korumaya devam edecek.
        findCustomer?.apply {
            customerName = newCustomerName ?: findCustomer.customerName
            customerEmail = newCustomerEmail ?: findCustomer.customerEmail
            customerTelNo = newCustomerTelNo ?: findCustomer.customerTelNo
        }

        // findCustomer?.customerId = 10 // Buna izin yok, çünkü abstract içinde setter'ı private.
    }

    // Bütün müşterileri siliyoruz.
    fun clearCustomerList() {
        customerList.clear()
    }

    // Sistemdeki müşterileri listeliyoruz
    fun listAllCustomer() {
        println("*ALL CUSTOMERS*")
        customerList.forEach { customer ->
            // with scope fonksiyonu ile her değişkene customer. ifadesini yazmaktan kurtuldum.
            with(customer) {
                println(
                    "Customer Id: $customerId\n" +
                            "Customer Name: $customerName\n" +
                            "Customer Email: $customerEmail\n" +
                            "Customer Tel No: $customerTelNo\n"
                )
            }
        }
    }
}