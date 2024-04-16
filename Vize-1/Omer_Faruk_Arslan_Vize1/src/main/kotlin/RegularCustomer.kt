//RegularCustomer sınıfının Customerdan miras alması ve sadakat puanı
class RegularCustomer(
    name : String,
    surName : String,
    eMail : String,
    phone : String,
    customerId : Int,
    val sadakatPuanı : Int
) : Customer (name , surName ,eMail , phone , customerId ){
    //Müşteri Bilgilerini yazdırma
    override fun toString(): String {
        return super.toString() + "Sadakat Puanı : $sadakatPuanı "
    }
}