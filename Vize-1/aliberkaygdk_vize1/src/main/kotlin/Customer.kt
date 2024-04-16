abstract class Customer( var name: String, var email: String, var phoneNumber: String) {

    abstract var customerId: String



    // detaylı bilgi verilmesi adına alt sınıflarda kullanılmıştır

    /*override fun toString(): String {
        return "\nMüşteri: $name" +
                "\nEposta: $email" +
                "\nTelefon Numarası: $phoneNumber" +
                "\nMüşteri ID: $customerId\n"
    }*/
}