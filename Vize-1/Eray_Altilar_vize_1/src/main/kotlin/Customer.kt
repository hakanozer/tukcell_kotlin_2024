


abstract class Customer(
    val customerId: String ,
    var name: String,
    var email: String,
    var phoneNumber: Long,
    val isVIP: Boolean /// özel tür olarak kullanıcıların vip olup olmamama durumunu veri olarak tutuyorum
) {


    /// Kullanıcıların bilgilerini toString Fonksyionunu override ederek yazdırma işlemi uygulatıyoruz
    override fun toString(): String {
        println("$name Kullanıcısının Bilgileri : ")
        return "Abone Numbarası:$customerId \nİsmi: $name \nE-posta adresi: $email \nTelefon numarası: (+90) $phoneNumber"
    }


}