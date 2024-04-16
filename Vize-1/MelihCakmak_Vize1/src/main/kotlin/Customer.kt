abstract class Customer(var name:String,var email:String,var phoneNumber:String){
     val customerID: Int



    companion object {
        var counter=0
    }
    init {
        counter++
        customerID= counter

    }


    override fun toString(): String {
        return "--------------------------\n" +
                "CustomerId: $customerID\n" +
                "Name: $name\n" +
                "Email: $email\n" +
                "Phone Number: $phoneNumber"
    }




}