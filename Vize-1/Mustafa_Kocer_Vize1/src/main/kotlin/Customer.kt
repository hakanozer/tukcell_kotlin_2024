package org.example

import RegularCustomer
import VIPCustomer

abstract class Customer( var cName : String, var cEmail : String, var cPhone : String){

    companion object {
        private var customerID = 0
        // companion obje oluşturup her nesne ürettiğimde 1 arttırıcam
        // böylelikle o müşterinin unique customer id'si olacak
        // private yaptım dışarıdan müdahale istemiyorum
    }

    private val customerId: Int = ++customerID
     // Her nesne üretildiğinde customerCount 1 artar


     abstract fun shop(totalPrice : Double)



    override fun toString(): String {
         if (this is RegularCustomer){
             return  "Customer ID: ${this.customerId}\nName: ${this.cName}\nEmail: ${this.cEmail}\nPhone Number: ${this.cPhone}\nLoyalty Points: ${this.loyaltyPoints}\n"
        }
        else if (this is VIPCustomer){
             return "Customer ID: ${this.customerId}\nName: ${this.cName}\nEmail: ${this.cEmail}\nPhone Number: ${this.cPhone}\nVIP Level: ${this.vipLevel}\n"
        }

        return "Customer ID: ${this.customerId}\nName: ${this.cName}\nEmail: ${this.cEmail}\nPhone Number: ${this.cPhone}\n"

    }

}