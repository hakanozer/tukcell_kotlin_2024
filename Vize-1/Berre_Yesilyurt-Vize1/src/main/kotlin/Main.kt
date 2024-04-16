package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val customer1=CustomerManager()

    val customer2=RegularCustomer(0,"Erva","Kızıl","5375586451")
    val customer3=VIPCustomer(0,"Buket","Kızıl","5375545951")

    customer2.printInformation() // Ayrı ayrı bilgileri listeler
    customer3.printInformation() // Ayrı ayrı bilgileri listeler


    while (true){


        println("Hangi işlemi yapmak istersiniz?")
        println("1 - Müşteri Ekle")
        println("2- Müşteri Güncelle")
        println("3 - Müşterinin Bilgilerini Listele")
        println("4 - Müşteri Sil")
        println("5 - Çıkış Yap")

        val process= readLine()?.toInt()

        when(process){
            1 -> {
                println("Hangi tipte müşteri ekleyeceğini seçiniz: 1 - RegularCustomer 2 - VIPCustomer")
                val typeOfCustomer= readLine()?.toInt()

                if(typeOfCustomer==null || typeOfCustomer !is Int){
                    println("Yanlış tipte veri girdinniz. Lütfen tekrar deneyiniz")
                    continue
                }

                else if(typeOfCustomer==1){
                    println("Eklemek istediğiniz müşterinin ismini giriniz")
                    val name= readLine()

                    println("Eklemek istediğiniz müşterinin email adresini giriniz")
                    val email= readLine()

                    println("Eklemek istediğiniz müşterinin telefon numarasını giriniz")
                    val telephoneNo= readLine()

                    customer1.addCustomer(RegularCustomer(0,name,email,telephoneNo))
                }

                else{
                    println("Eklemek istediğiniz müşterinin ismini giriniz")
                    val name= readLine()

                    println("Eklemek istediğiniz müşterinin email adresini giriniz")
                    val email= readLine()

                    println("Eklemek istediğiniz müşterinin telefon numarasını giriniz")
                    val telephoneNo= readLine()
                    customer1.addCustomer(VIPCustomer(0,name,email,telephoneNo))
                }

            }

            2 ->{
                println("Hangi tipte müşteri ekleyeceğini seçiniz: 1 - RegularCustomer 2 - VIPCustomer")
                val typeOfCustomer= readLine()?.toInt()

                if(typeOfCustomer==1){

                    println("Sadıklık puanının güncellenmiş halini giriniz")
                    val loyaltyPoint= readLine()?.toInt()

                    println("Güncel ismi giriniz")
                    val name= readLine()

                    println("Güncel email adresini giriniz")
                    val email= readLine()

                    println("Güncel telefon numarasını giriniz")
                    val telephoneNo= readLine()

                    println("Güncellenecek müşterinin id numarasını giriniz")
                    var id= readLine()?.toInt()

                    if(id==null || id !is Int || id<=0){
                        println("Geçersiz bir id girdiniz, lütfen tekrar deneyiniz")
                        continue
                    }

                    customer1.updateCustomer(id,RegularCustomer(loyaltyPoint,name,email,telephoneNo))
                }

                else{
                    println("Vip levelinin güncellenmiş halini giriniz")
                    val vipLevel= readLine()?.toInt()

                    println("Güncel ismi giriniz")
                    val name= readLine()

                    println("Güncel email adresini giriniz")
                    val email= readLine()

                    println("Güncel telefon numarasını giriniz")
                    val telephoneNo= readLine()

                    println("Güncellenecek müşterinin id numarasını giriniz")
                    val id= readLine()?.toInt()

                    if(id==null || id !is Int || id<=0){
                        println("Geçersiz bir id girdiniz, lütfen tekrar deneyiniz")
                        continue
                    }

                    customer1.updateCustomer(id,VIPCustomer(vipLevel,name,email,telephoneNo))
                }
            }

            3 ->{
                customer1.listCustomer()
            }

            4 -> {
                println("Silmek istediğini müşterinin id numarasını giriniz")
                val id= readLine()?.toInt()
                customer1.removeCustomer(id)
            }

            5 ->{
                println("Çıkış yapılıyor...")
                break
            }
        }

    }

}