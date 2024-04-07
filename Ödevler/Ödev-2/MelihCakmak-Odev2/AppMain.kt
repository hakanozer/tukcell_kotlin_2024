import Soru1.TatilMenusu
import Soru1.Yemek
import Soru1.YemekMenu
import Soru2.Student
import Soru2.StudentDatabase
import Soru3.Animal
import Soru3.Zoo
import Soru4.Book
import Soru4.Library
import Soru5.OnlineShopping
import Soru5.Product

fun main() {
println("------------------------------------------ Soru1 ------------------------------------------")
val menu=YemekMenu()
    menu.yemekEkle(Yemek("Pizza", 200))
    menu.yemekEkle(Yemek("Makarna", 150))
    menu.yemekEkle(Yemek("Salata", 50))
    menu.yemekleriListele()
    println(menu.fiyatFiltrele(150))


    val tatilMenu =TatilMenusu()
    tatilMenu.yemekEkle(Yemek("Hindi", 300))
    tatilMenu.yemekEkle(Yemek("Kek", 100))
    tatilMenu.yemekleriListele()
    println(tatilMenu.fiyatFiltrele(150))

println("-------------------------------------------------------------------------------------------")

println("------------------------------------------ Soru2 ------------------------------------------")
    val studentDatabase=StudentDatabase()

    val student1=Student("Melih Cakmak",270201048)
    val student2=Student("Ahmet Arslan",270201000)

    studentDatabase.addStudent(student1)
    studentDatabase.addStudent(student2)

    studentDatabase.addCoursetoStudent(student1,"math")
    studentDatabase.addCoursetoStudent(student2,"physics")
    studentDatabase.addCoursetoStudent(student2,"chem")

    studentDatabase.printStudents()

    println("Most Courses : ${studentDatabase.studentMostCourses()}")


println("-------------------------------------------------------------------------------------------")



println("------------------------------------------ Soru3 ------------------------------------------")
    val zoo = Zoo()

    zoo.addAnimal(Animal("Aslan", "Memeli", "Afrika"))
    zoo.addAnimal(Animal("Zürafa", "Memeli", "Afrika"))
    zoo.addAnimal(Animal("Penguen", "Kuş", "Antarktika"))
    zoo.addAnimal(Animal("Köpekbalığı", "Balık", "Okyanus"))

    zoo.printAnimals()

    zoo.getAnimalsByHabitat("Afrika")



println("-------------------------------------------------------------------------------------------")


println("------------------------------------------ Soru4 ------------------------------------------")
val library=Library()

    library.addBook(Book("Fyodor Dostoyevski","Suç ve Ceza"))
    library.addBook(Book("Jane Austen","Gurur ve Önyargı"))
    library.addBook(Book("Jane Austen","Emma"))
    library.addBook(Book("Gabriel García Márquez:","Yüzyıllık Yalnızlık"))


 library.listOfBooks()

  library.booksByAuthor("Jane Austen")



println("-------------------------------------------------------------------------------------------")



println("------------------------------------------ Soru5 ------------------------------------------")
    val product1 = Product(0,"Elma", 15.0)
    val product2 = Product(1,"Muz", 33.5)
    val product3 = Product(2,"Laptop", 515.0)
    val product4 = Product(3,"Telefon", 133.5)
    val onlineShopping = OnlineShopping()
    onlineShopping.addProduct(product1)
    onlineShopping.addProduct(product2)

    onlineShopping.printProducts()
    onlineShopping.getTotalCost()






println("-------------------------------------------------------------------------------------------")




}

