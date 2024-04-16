class CustomerManager {

    private val customerList: MutableList<Customer> = mutableListOf()

    /// Abone ekleme fonksyionu
    fun addCustomer(customer: Customer) {

        val existedCustomer = customerList.find { it.customerId == customer.customerId }
        /// Mevcut abone listemizde yeni eklenecek abone numarasında bir abone var ise ekeleme gerçekleşmesin
        /// Böylece Her Id unique olabilir
        if (existedCustomer != null) {
            println("Abone No: ${customer.customerId} ile kayıtlı olan müşteri zaten mevcut. Ekleme yapılamadı.")
        } else {
            customerList.add(customer)
            println("${customer.name} Kullanıcısı eklendi!")
        }
    }

    /// Belirtilen aboneyi siliyoruz
    fun removeCustomer(customer: Customer){
        if(customer != null) {
            customerList.remove(customer)
            println("${customer.name} Kullanıcısı silindi !")
        } else {
            println("Kullanıcısı Bulunamadı !")
        }
    }

    /// Abone numarasını baz alarak kullanıcıların bilgilerini güncelliyoruz (CustomerId değişmiyor)
    fun updateCustomerInfo(customerId:String ,name: String, email: String? = null, phoneNumber: Long? = null) {
        val customer = customerList.find { it.customerId == customerId }
        if (customer != null) {
            name?.let { customer.name = it }
            email?.let { customer.email = it }
            phoneNumber?.let { customer.phoneNumber = it }
            println("${customer.name} Kullanıcısı Güncellendi")
        } else {
            println("Bu abone nuamrasına ait bir kayıt bulunmamakta !")
        }

    }
    ///  Kullanıcıları VIP olup olmama durumuna göre listeliyoruz
    fun listCustomers() {

        println("VIP Üyeler:")
        customerList.filter { !it.isVIP }.forEach {
            println(it)
            println("------------------------------------")
            }

        println("Normal Üyeler:")
        customerList.filter { it.isVIP }.forEach {
            println(it)
            println("------------------------------------")
            }
        }
}
