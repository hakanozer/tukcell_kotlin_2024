//Müşteri Bilgilerini Tutan Abstract
abstract class Customer(

    var name: String,
    var surName: String,
    var eMail: String,
    var phone : String,
    val customerId : Int,

){
    override fun toString(): String {
        return  "Müşteri Bilgileri : , Adı : $name ,Soy Adı : $surName ,Mail Adresi : $eMail ,Telefon Numarası : $phone ,Kullanıcı Adı : $customerId  "
    }
}