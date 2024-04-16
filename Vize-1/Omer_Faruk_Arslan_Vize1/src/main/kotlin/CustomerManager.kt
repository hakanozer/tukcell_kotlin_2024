//Müşteri Türleninin Tutulduğu Liste
class CustomerManager {
    private val musteriler = mutableListOf<Customer>()

    //Müşteri Ekleme
    fun addCustomer(customer: Customer) {
        musteriler.add(customer)
    }

    //Güncelleme
    fun updateCustomer(customerId: Int, newName: String?, newSurName: String?, newPhone: String?, newEMail: String?) {
        val customer = musteriler.find { it.customerId == customerId }
        customer?.let {
            it.name = newName ?: it.name
            it.surName = newSurName ?: it.surName
            it.eMail = newEMail ?: it.eMail
            it.phone = newPhone ?: it.phone
        }
    }

    // Müşteri Listeleme
    fun listCustomers() {
        musteriler.forEach {
            println(it)

        }
    }
    // Müşteri Bulma
    fun findCustomer(customerKim : Int) {
        val customer = musteriler.find { it.customerId == customerKim }
        if (customer != null){
            println(customer)
        }else {
            println("Müşteri Bulunamadı")
        }




        }
    }
