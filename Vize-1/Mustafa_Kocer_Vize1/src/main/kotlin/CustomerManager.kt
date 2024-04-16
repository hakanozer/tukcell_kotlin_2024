import org.example.Customer

class CustomerManager {
    private val customerList = mutableSetOf<Customer>()
    // aynı customer'i tekrar eklemesin diye set ile tutuyorum

    fun addCustomer(customer: Customer){
        this.customerList.add(customer)
    }

    fun removeCustomer(customer: Customer){
        if (customerList.contains(customer)) {
            customerList.remove(customer)
            println("Müşteri başarıyla silindi.")
        } else {
            println("Müşteri listede bulunamadı.")
        }
    }

    fun updateCustomerName(customer: Customer, newName: String) {
        // müşteri listede varsa ismini güncelle, yoksa ismini güncelleyip listeye ekle

        if (customerList.contains(customer)) {
            // Müşteri zaten listenin içinde
            customer.cName = newName
        } else {
            // Müşteri listede yok
            customer.cName = newName
            customerList.add(customer)
        }
    }

    fun updateCustomerEMail(customer: Customer, newEMail : String) {
        // müşteri listede varsa mailini güncelle, yoksa ismini güncelleyip listeye ekle

        if (customerList.contains(customer)) {
            // Müşteri zaten listenin içinde
            customer.cEmail = newEMail
        } else {
            // Müşteri listede yok
            customer.cEmail = newEMail
            customerList.add(customer)
        }

    }

    fun updateCustomerPhone(customer: Customer, newPhoneNumber : String) {
        // müşteri listede varsa telefon numarasını güncelle, yoksa ismini güncelleyip listeye ekle

        if (customerList.contains(customer)) {
            // Müşteri zaten listenin içinde
            customer.cPhone = newPhoneNumber
        } else {
            // Müşteri listede yok
            customer.cPhone = newPhoneNumber
            customerList.add(customer)
        }
    }

    fun updateLoyaltyPoint(customer: Customer, newPoints : Int){
        // eğer regulerCustomer sınıfındaysa, sadakat puanını güncelleyebilir
     if(customer is RegularCustomer){
         if (customerList.contains(customer)) {
             // Müşteri zaten listenin içinde
             customer.loyaltyPoints = newPoints
         } else {
             // Müşteri listede yok
             customer.loyaltyPoints = newPoints
             customerList.add(customer)
         }
     }
    }

    fun updateVIPLevel(customer: Customer, newLevel : Int){
        // eğer vipcustomer sınıfındaysa, vip levelini güncelleyebilir
        if(customer is VIPCustomer){
            if (customerList.contains(customer)) {
                // Müşteri zaten listenin içinde
                customer.vipLevel = newLevel
            } else {
                // Müşteri listede yok
                customer.vipLevel = newLevel
                customerList.add(customer)
            }
        }
    }


    fun listCustomers(){
        // customer listesine eklenmiş customerları listeler
        for (customer in customerList){
            println(customer.toString())
        }
    }



}