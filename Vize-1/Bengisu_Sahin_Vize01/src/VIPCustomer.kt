// This class is a type of customer
class VIPCustomer(name: String, email: String, phoneNumber: Long, var vipLevel:Int) :
    Customer(name, email, phoneNumber
) {
    // To show customer infos, it was overrided
    override fun toString(): String {
        return "${generateCustomerId()} ID, $name, $email, $phoneNumber, Vip Level: $vipLevel"
    }


}