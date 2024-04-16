package org.example

class RegularCustomer(var loyaltyPoints:Int?, name: String?, email: String?, telephoneNo: String?):
    Customer(name, email, telephoneNo) {
    override fun printInformation(): String {
        return "RegularCustomer Sınıfında bulunan $name adındaki müşterimizin mail adresi $email ve telefon numarası $telephoneNo'dur. Sadakat puanı ise $loyaltyPoints'dir."
    }


}