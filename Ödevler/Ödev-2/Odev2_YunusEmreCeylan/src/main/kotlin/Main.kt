package org.example

fun main() {
    // 1. Soru: Menü ve özel menü oluşturma
    val menu = Menu()
    menu.addItem("Çorba", 39.99)
    menu.addItem("Pilav", 27.99)
    menu.addItem("Kavurma", 129.99)

    val specialMenu = SpecialsMenu()
    specialMenu.addItem("Pasta", 38.99)
    specialMenu.addItem("Baklava", 48.99)

    println("Menü:")
    menu.listItemsInRange(5.0, 10.0)
    println("\nTatlı Menüsü:")
    specialMenu.listItemsInRange(5.0, 15.0)

    // 2. Soru: Öğrenci sistemi
    val students = listOf(
        Student("Ayşe", 1, listOf("Matematik", "Türkçe")),
        Student("Bilal", 2, listOf("Matematik", "İnkılap", "Fizik")),
        Student("Fatma", 3, listOf("Tarih", "Resim")),
        Student("Esra", 4, listOf("Matematik", "Fizik")),
        Student("Mehmet", 5, listOf("Biyoloji", "Türkçe", "inkılap"))
    )

    val studentsWithMostCourses = Student.findStudentsWithMostCourses(students)
    studentsWithMostCourses.forEach {
        println("En çok dersi alan öğrenci veya öğrenciler: ${it.student.name}")
        println("Ders sayısı: ${it.courseCount}")
    }



    // 3. Soru: Hayvanat bahçesi
    val zoo = Zoo()
    zoo.addNewAnimal(Animal("Aslan", "Kedi", "Savannah"))
    zoo.addNewAnimal(Animal("Maymun", "Maymun", "Jungle"))
    zoo.addNewAnimal(Animal("Yılan", "Sürüngen", "Forest"))

    println("\nAnimals in the Savannah:")
    zoo.listAnimalsHabitat("Savannah")

    // 4. Soru: Kütüphane sistemi
    val library = Library()

    library.addBook(Book("Harry Potter", "J.K. Rowling"))
    library.addBook(Book("Harry Potter and Chamber Of Secrets", "J.K. Rowling"))
    library.addBook(Book("1984", "George Orwell"))
    library.addBook(Book("To Kill a Mockingbird", "Harper Lee"))

    library.listBooks()
    println()

    library.listBooksByAuthor("J.K. Rowling")


    // 5. Soru: Online alışveriş ve sepeti
    val onlineShop = ShoppingCart()

    onlineShop.addItemToCart("Laptop", 12000.0)
    onlineShop.addItemToCart("Telefon", 8000.0)
    onlineShop.addItemToCart("Kıyafet", 100.0)

    println("Toplam harcama: ${onlineShop.calculateTotalAmount()}")

    onlineShop.removeItemFromCart("Telefon")

    println("Telefonu çıkardıktan sonraki toplam harcama: ${onlineShop.calculateTotalAmount()}")

    onlineShop.clearCart()

    println("Sepeti boşalttıktan sonraki harcama: ${onlineShop.calculateTotalAmount()}")

}
