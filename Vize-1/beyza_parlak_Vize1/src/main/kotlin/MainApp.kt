// BEYZA PARLAK
fun main(){
    // customerManager nesnesi oluşturuyorum
    var customerManager = CustomerManager()

    // RegularCustomer classından customer üretiyorum ve addCustomer metodu ile customerManagera ekliyorum
    var regularCustomer1 = RegularCustomer(customerId = "1", fullName = "Beyza Parlak", phoneNumber = "5301230121", email = "beyza@gmail.com", gender = "woman", address = "Hatay", loyaltyPoints = 100)
    var regularCustomer2 = RegularCustomer(customerId = "2",fullName = "Betül Parlak", phoneNumber = "5591230121", email = "betul@gmail.com", gender = "woman", address = "Hatay", loyaltyPoints = 80)
    var regularCustomer3 = RegularCustomer(customerId = "3",fullName = "Asli Gültekin", phoneNumber = "5301230100", email = "asli@gmail.com", gender = "woman", address = "Burdur", loyaltyPoints = 95)
    var regularCustomer4 = RegularCustomer(customerId = "4",fullName = "Sibel Çakmak", phoneNumber = "5301230000", email = "sibel@gmail.com", gender = "woman", address = "Trabzon", loyaltyPoints = 10)
    customerManager.addCustomer(regularCustomer1)
    customerManager.addCustomer(regularCustomer2)
    customerManager.addCustomer(regularCustomer3)
    customerManager.addCustomer(regularCustomer4)

    // VIPCustomer classından customer üretiyorum ve addCustomer metodu ile customerManagera ekliyorum
    var VIPCustomer1 = VIPCustomer(customerId = "5","Ahmet Bilmem", "ahmet@gmail.com", "5309630181", "İstanbul", "man", 2,)
    var VIPCustomer2 = VIPCustomer(customerId = "6","Mehmet Bilmem", "mehmet@gmail.com", "5309630000", "Ankara", "man", 4)
    var VIPCustomer3 = VIPCustomer(customerId = "7","Selin Bilmem", "selim@gmail.com", "5999630181", "Kastamonu", "woman", 1)
    // eklemek istediğim customer yazıyorum
    customerManager.addCustomer(VIPCustomer1)
    customerManager.addCustomer(VIPCustomer2)
    customerManager.addCustomer(VIPCustomer3)

    // tüm customer ları listeleme
    customerManager.showCustomer()

    // hangi id ye sahip customer ı silmek istiyorsam değerini veriyorum
    customerManager.removeCustomer("4")

    // güncellemek istediğim customerın id değerini veriyorum ve güncellenmesini istediğim nesnenin yeni değerini giriyorum
    customerManager.updateCustomer( "7", "Beyza")

    // add, remove, update ve show(listeleme) işlemleri tamamdır
}