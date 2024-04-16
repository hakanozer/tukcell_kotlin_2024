import java.util.*

abstract class Customer (val musteriAdi:String,val musteriEmail:String,val musteriPhone:String,val customerId: UUID){

    override fun toString(): String {
        return "Customer ID: $customerId\nName: $musteriAdi\nEmail: $musteriEmail\nPhone: $musteriPhone"
    }


}
