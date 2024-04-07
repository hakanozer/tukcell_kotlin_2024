package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val regularMenu = Menu()
    regularMenu.addMenuItem("Mantı", 25.0)
    regularMenu.addMenuItem("İskender", 20.0)
    regularMenu.addMenuItem("Kayseri's Sausage", 15.0)

    // Belirli bir fiyat aralığındaki yemekleri listeleme
    println("Meals that between specified prices: ${regularMenu.listItemsInRange(15.0, 25.0)}")

    // Tatil menüsü oluşturma
    val holidayMenu = HolidayMenu()
    holidayMenu.addMenuItem("Cat Leg", 40.0)
    holidayMenu.addMenuItem("Milky Dessert", 30.0)

    // Ekstra tatil yemeği ekleme
    holidayMenu.addHolidayItem("Beverage", 50.0)

    // Belirli bir fiyat aralığındaki yemekleri listeleme (tatil menüsü için)
    println("In holiday menu meals that specified price: ${holidayMenu.listItemsInRange(30.0, 50.0)}")
//2

// Öğrenci listesi oluşturma
    val students = listOf(
        Student("Ahmet", 123, listOf("Physical Education", "Physics", "BrainStorming")),
        Student("Ayşe", 456, listOf("History", "Toy's History")),
        Student("Mehmet", 789, listOf("Biology", "Literary", "Philosophy"))
    )

    // Her öğrencinin aldığı dersleri listeleme
    students.forEach { it.listCourses() }

    // En yüksek ders sayısına sahip öğrenciyi bulma fonksiyonu
    fun findStudentWithMostCourses(): Student? {
        return students.maxByOrNull { it.courses.size }
    }

    // En yüksek ders sayısına sahip öğrenciyi bulup yazdırma
    val studentWithMostCourses = findStudentWithMostCourses()
    if (studentWithMostCourses != null) {
        println("Student that have the most lessons: ${studentWithMostCourses.name}")
    } else {
        println("Student couldn't find.")
    }
//3
    // Hayvanlar oluşturma
    val lion = Animal("Bird", "Felis birdo", "Savanna")
    val tiger = Animal("Panther", "Panthera tigris", "Forest")
    val elephant = Animal("Fish", "Fisphas maximus", "Lake")
    val giraffe = Animal("Zebra", "Zebraffa camelopardalis", "Savanna")

    // Hayvanat bahçesi oluşturma
    val zoo = Zoo()
    zoo.addAnimal(lion)
    zoo.addAnimal(tiger)
    zoo.addAnimal(elephant)
    zoo.addAnimal(giraffe)

    // Belirli bir yaşam alanına sahip hayvanları listeleme
    zoo.listAnimalsByHabitat("Jungle")
//4
    // Kütüphane oluşturma
    val library = Library()

    // Kitapları eklemek
    library.addBook(Book("Notes From UnderGround", "Fyodor Dostoyevski"))
    library.addBook(Book("War and Peace", "Lev Tolstoy"))
    library.addBook(Book("Animal Farm", "George Orwell"))
    library.addBook(Book("Meeting with Human ", " Alfred Adler"))
    library.addBook(Book(" Emotional Intelligent", "Daniel Golemann"))

    // Tüm kitapları listeleme
    library.listBooks()

    // Belirli bir yazarın kitaplarını listeleme
    library.listBooksByAuthor("Fyodor Dostoyevski")
//5
    // Online alışveriş uygulaması oluşturma
    val onlineShop = OnlineShop()

    // Kullanıcıların sepetlerine ürün eklemek
    onlineShop.addProductToCart("user1", Product("Clock", 1500.0))
    onlineShop.addProductToCart("user1", Product("Monitor", 100.0))
    onlineShop.addProductToCart("user2", Product("Razer-Mouse", 2000.0))
    onlineShop.addProductToCart("user2", Product("Keyboard", 150.0))

    // Kullanıcının sepetini listeleme
    println("user1's cart: ${onlineShop.calculateTotalSpending("user1")} TL")
    println("user2's cart: ${onlineShop.calculateTotalSpending("user2")} TL")

    // Kullanıcının sepetinden ürün çıkarma
    onlineShop.removeProductFromCart("user1", Product("Clock", 1500.0))

    // Kullanıcının sepetini temizleme
    onlineShop.clearCart("user2")

    // Temizlenmiş sepetin kontrolü
    println("user1's updated cart: ${onlineShop.calculateTotalSpending("user1")} TL")
    println("user2's updated cart: ${onlineShop.calculateTotalSpending("user2")} TL")
}
