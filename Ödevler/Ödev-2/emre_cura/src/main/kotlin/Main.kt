import question_1.HolidayMenu
import question_1.Menu
import question_2.Course
import question_2.Student
import question_3.Animal
import question_3.Lion
import question_4.AntalyaLibrary
import question_4.Book
import question_5.Computer
import question_5.OnlineShop
import question_5.Product

fun main() {
    println("*********************Question-1*********************")


    val menu = Menu()
    println(menu.menuMap)
    val filteredMenu = menu.filterPrice(100.0, 140.0)
    println(filteredMenu)
    menu.addFood("Adana Kebab", 180.0)
    println(menu.menuMap)
    val holidayMenu = HolidayMenu()
    println(holidayMenu.menuMap)
    holidayMenu.addFood("Toast",80.0)
    println(holidayMenu.menuMap)


    println("*********************Question-2*********************")



    val studentCourses1 = mutableListOf(Course(1,"Discrete Math"), Course(2,"Mobile Programming"),Course(3,"Software Engineering"))
    val studentCourses2 = mutableListOf( Course(2,"Mobile Programming"),Course(3,"Software Engineering"))
    val studentCourses3 = mutableListOf(Course(3,"Software Engineering"))

    val student1 = Student(101, "Emre Cura", studentCourses1)
    val student2 = Student(102, "Ali", studentCourses2)
    val student3 = Student(103, "Mehmet", studentCourses3)

    val listOfStudent = mutableListOf<question_2.Student>()
    listOfStudent.add(student1)
    listOfStudent.add(student2)
    listOfStudent.add(student3)

    student1.lectures(listOfStudent)
    student1.mostNumberOfCourse(listOfStudent)


    println("*********************Question-3*********************")



    val animal1 = Lion("Lion", "Panthera leo", "Savannah")
    val animal2 = Animal("Tiger", "Panthera tigris", "Jungle")
    val animal3 = Animal("Elephant", "Loxodonta africana", "Savannah")
    val animal4 = Animal("Penguin", "Spheniscus", "Antarctica")

    val listOfAnimal = mutableListOf<question_3.Animal>()
    listOfAnimal.add(animal1)
    listOfAnimal.add(animal2)
    listOfAnimal.add(animal3)
    listOfAnimal.add(animal4)

    animal1.sound()

    val zoo = question_3.Zoo(listOfAnimal)
    zoo.commonHabitat("Savannah")


    println("*********************Question-4*********************")

    val bookList = mutableListOf<Book>()
    bookList.add(Book(1, "Book 1", "Author 1"))
    bookList.add(Book(2, "Book 2", "Author 1"))
    bookList.add(Book(3, "Book 3", "Author 3"))
    bookList.add(Book(4, "Book 4", "Author 4"))
    bookList.add(Book(5, "Book 5", "Author 5"))
    val book = Book(6, "Book 6", "Author 3")

    val library = AntalyaLibrary(bookList)

    library.listBook()
    library.addBook(book)
    println("Author 3's books -> ${library.findBooksOfAuthor("Author 3")}")


    println("*********************Question-5*********************")

    val product1 = Computer(1, "Laptop", 1500.0, "Monster")
    val product2 = Product(2, "Phone", 800.0)
    val product3 = Product(3, "Headphones", 100.0)

    val onlineShop = OnlineShop()
    onlineShop.addToBasket(product1)
    onlineShop.addToBasket(product2)
    onlineShop.addToBasket(product3)

    onlineShop.printElements()
    println("Total Cost: ${onlineShop.totalPrice()}")

    onlineShop.removeFromBasket(product3)
    onlineShop.printElements()
    println("Total Cost: ${onlineShop.totalPrice()}")

    onlineShop.clearBasket()
    println(onlineShop.basket.products)
    println("Total Cost: ${onlineShop.totalPrice()}")


}