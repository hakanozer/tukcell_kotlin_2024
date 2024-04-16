//RegularCustomer sınıfının Customerdan miras alması ve Vip özelliği
class VipCustomer(
    name : String,
    surName : String,
    eMail : String,
    phone : String,
    customerId : Int,
    val vipMusteri : Int
) :Customer (name , surName ,eMail , phone , customerId ){
    //Müşteri Bilgilerini yazdırma
    override fun toString(): String {
        return super.toString() + "VİP DERECESİ : $vipMusteri "
    }
}