abstract class Customer(val customerId: String ,var fullName:String, var email:String, var phoneNumber: String,var address: String, var gender: String) {
    // Customer ana classtır.
    // abstract class olduğunda miras alınacak classa open eklemek gereksizdir

    // toString() metodunu fonk içinde eziyorum
    override fun toString(): String {
        return "Customer ID: $customerId - Name: $fullName - Email: $email - Phone Number: $phoneNumber " +
                "- Address: $address -  Gender: $gender"
    }
}