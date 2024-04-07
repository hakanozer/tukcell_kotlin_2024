import soru1.HolidayMenu
import soru1.Menu
import soru2.Student
import soru2.StudentList
import soru3.Animal
import soru3.Zoo
import soru4.PersonalLibrary
import soru5.PremiumUserShop

fun main() {
    println("===============1.Soru==============")
    val holidayMenu = HolidayMenu()
    val menu = Menu()
    menu.addFood("Köfte", 184.99)
    menu.addFood("Makarna", 124.99)
    menu.addFood("Dolma", 164.99)
    menu.addFood("Karnıyarık", 174.99)
    menu.listFoodsInPriceRange(130.0, 180.5)
    holidayMenu.addFood("Fasulye", 114.99)
    holidayMenu.addFood("Pilav", 104.99)
    holidayMenu.addFood("Bezelye", 124.99)
    holidayMenu.listFoodsInPriceRange(100.0, 160.0)

    println("===============2.Soru==============")
    val studentList = StudentList()
    studentList.add(Student("Sercan", 1, listOf("Kotlin", "Java", "Matematik")))
    studentList.add(Student("Ali", 2, listOf("Otomata", "Kotlin", "Fizik")))
    studentList.add(Student("Veli", 3, listOf("Mikroişlemci", "Kotlin", "Makina Öğrenmesi", "Veri Yapıları")))
    val studentMostCourses = studentList.findStudentMostCourses()
    println("En çok dersi olan öğrenci : ${studentMostCourses?.name}, Numarası : ${studentMostCourses?.number}, Aldığı dersler : ${studentMostCourses?.courses}")
    studentList.listAllCourses()



    println("===============3.Soru==============")
    val zoo = Zoo()
    val aslan = Animal("Aslan", "Memeli", "Orman")
    val fil = Animal("Fil", "Memeli", "Orman")
    val yilan = Animal("Yılan", "Memeli", "Sulak Yerler")
    zoo.addAnimal(aslan)
    zoo.addAnimal(fil)
    zoo.addAnimal(yilan)
    zoo.listAnimalsByHabitat("orman")

    println("===============4.Soru==============")
    val personalLibrary = PersonalLibrary()
    personalLibrary.addBook("Serenad", "Zülfü Livaneli")
    personalLibrary.addBook("Kürk Mantolu Madonna", "Sabahattin Ali")
    personalLibrary.addBook("Kuyucaklı Yusuf", "Sabahattin Ali")
    personalLibrary.listBooks()
    personalLibrary.listOfBooksByAuthor("Sabahattin Ali")


    println("===============5.Soru==============")
    val premiumUserShopShop = PremiumUserShop()
    premiumUserShopShop.addToCart("Sercan", "Laptop", 1500.0)
    premiumUserShopShop.addToCart("Sercan", "Mouse", 50.0)
    premiumUserShopShop.removeFromCart("Sercan", "Mouse")
    val total = premiumUserShopShop.calcTotal("Sercan")
    println(total)
}