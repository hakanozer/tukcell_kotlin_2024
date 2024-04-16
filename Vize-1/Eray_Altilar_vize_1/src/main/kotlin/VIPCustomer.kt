class VIPCustomer (
    customerId : String, name: String, email: String, phoneNumber: Long

) : Customer( customerId,name, email, phoneNumber , isVIP = true) {
    /// vip seviyesini burada saklıyoruz
    var vipLevel : Int = 0

    fun showVIPLevel() {
        println("$name Abonesinin VIP Seviyesi : $vipLevel")
    }



}