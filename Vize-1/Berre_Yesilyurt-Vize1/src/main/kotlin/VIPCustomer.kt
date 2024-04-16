package org.example

class VIPCustomer(val vipLevel:Int?, name: String?, email: String?, telephoneNo: String?):
    Customer(name, email, telephoneNo) {
    override fun printInformation(): String {
        return "VIPCustomer Sınıfında bulunan $name adındaki müşterimizin mail adresi $email ve telefon numarası $telephoneNo'dur. VipLevel'i ise $vipLevel'dir."

    }

}