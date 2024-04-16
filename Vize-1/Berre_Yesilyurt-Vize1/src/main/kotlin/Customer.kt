package org.example

abstract class Customer(var name:String?,var email:String?,var telephoneNo:String?) {

    private var id:Int=0;
    fun getId()=id // Müşterinin id'sini döner

    init{ // er seferinde id'nin artması için companion obect içerisindeki veriyi bu şekilde revize ettim
        id=counter;
        counter++
    }

    companion object{
        var counter=1
    }

    abstract fun printInformation():String // Alt sınıflarca kullanılacak metot

    override fun toString(): String {

        return printInformation()
    }

}