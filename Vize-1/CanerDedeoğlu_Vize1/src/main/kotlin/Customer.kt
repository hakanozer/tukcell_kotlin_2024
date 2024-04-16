abstract class Customer ( val customerId : Int, var customerName : String,
                          var customerMail : String, var customerPhoneNumber : String, var customerCity : String )
{


    override fun toString():String
    {
        return "Customer Id : $customerId , Customer Name : $customerName, Customer Mail : $customerMail, Customer Phone Number : $customerPhoneNumber, Customer City :$customerCity "
    }
}