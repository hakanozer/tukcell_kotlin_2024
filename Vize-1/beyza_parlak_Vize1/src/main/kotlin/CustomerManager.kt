// tüm customerların saklanacağı class
class CustomerManager {

    // tüm müşterileri mutable list içinde Customer türünde tutacağım
    val customers: MutableList<Customer> = mutableListOf()

    // müşterilerin ekleneceği fonk. ekleme işlemini add() metodu ile mutableList içerisine yapacağım
    fun addCustomer(customer: Customer){
        customers.add(customer)
    }

    // müşteri silme fonk yazacağım
    fun removeCustomer(customerId: String){
        //indexOfFirst metodu ile customers içinde dolaşabiliriz. eğer istediğimiz özellik listede yoksa -1 var ise index değeri döndürür. point içinde bu index değerini tutacağım
        val point = customers.indexOfFirst {
            it.customerId == customerId
        }

        // point değeri -1 değilse yani o müşteri listede varsa kaldırma işlemini removeAt() metodu ile yapıyorum
        if(point != -1){
            customers.removeAt(point)
            println("Customer with $customerId ids successfully removed.")
        }else{ // point -1 ise yani müşteri listede yoksa println() yazdırıyorum
            println("Customer with $customerId ids not found.")
        }
    }

    // müşteri bilgilerini güncelleme fonk
    // customerId güncellenmesi istenen customer, newCustomer ise güncellenmiş customer olacak
    fun updateCustomer(customerId: String, newName: String? = null, newEmail: String? = null, newPhoneNumber: String? = null,
                       newGender: String? = null){

        //indexOfFirst metodu ile customers içinde dolaşabiliriz. eğer istediğimiz özellik listede yoksa -1 var ise index değeri döndürür. point içinde bu index değerini tutacağım
        val point = customers.indexOfFirst {
            it.customerId == customerId
        }

        // index değeri -1 değilse name, email, phoneNumber, gender değerlerinden birini güncelleceğim
        if (point != -1){
            val update = customers[point]
            // ? işareti new ile başlayan değişkenler null mü kontrolünü sağlar ve let operatörüyle güvenli çalışmayı sağlar
            // newName değişkeni null değilse update e name özelliği atanır. burada it, değişkenin kendisidir
            newName?.let { update.fullName = it }
            newEmail?.let { update.email = it }
            newPhoneNumber?.let { update.phoneNumber = it }
            newGender?.let { update.gender = it }

        }else{ // dönen değer -1 ise println içindeki yazıyı yazdıracağım
            println("$customerId not found !")
        }
    }

    // tüm müşterileri listeleme fonk yazacağım
    fun showCustomer(){
        if (customers.isNotEmpty()){
            // format: 12. $customer. her müşterinin indexini buluyorum ve index 0 dan başladığı için bir ekliyorum ki müşterinin sırası belirlensin
            var customerList = customers.forEachIndexed { index, customer -> println("${index + 1}. $customer") }
            println("Customers List: $customerList")
        }else{
            println("Customers not found !")
        }

    }




}