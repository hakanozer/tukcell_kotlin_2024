package org.example

open class CustomerManager {

    val customerList= mutableListOf<Customer>()

    fun addCustomer(customer:Customer){
        customerList.add(customer)
    }

    fun updateCustomer(id:Int?,updatedDatas:Customer){
        val allCustomerList=getCustomer() // Tüm müşterileri çeker
        allCustomerList.forEach { // Tüm müşterilerin içerisinden, bize parametre olarak verilen müşterinin verilerini günceller sadece
            if(it.getId()==id){
                it.name=updatedDatas.name
                it.email=updatedDatas.email
                it.telephoneNo=updatedDatas.telephoneNo
            }
        }

    }

    fun getCustomer()=customerList // Tüm listeyi döndürür

    fun listCustomer(){ // Müşterileri listeler
        val allCustomerList=getCustomer()
        allCustomerList.forEach {
            println("Müşteriler")
            println("---")
            println(" ID : ${it.getId()} AD : ${it.name} EMAİL : ${it.email} TELEFON : ${it.telephoneNo} ")
        }
    }

    fun removeCustomer(id:Int?) { // Listeden eleman kaldırmak
        customerList.forEachIndexed() { index, it ->
            if (it.getId() == id) {
                customerList.removeAt(index)
            }
        }

    }
}