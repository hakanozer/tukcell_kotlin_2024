import library.Book
import library.Library
import restaurant.Food
import restaurant.HolidayMenu
import restaurant.Menu
import school.Student
import school.Students
import shopping.FastMarket
import shopping.MealOrder
import shopping.OnlineShop
import shopping.Product
import zoo.Animal
import zoo.Zoo

fun main() {
    // 1. QUESTION RESTAURANT MENUS
    val menu = Menu()
    val holidayMenu = HolidayMenu()

    println(menu.getRecipes())
    println(holidayMenu.getRecipes())

    println(menu.filterItems(10, 20))
    println(holidayMenu.filterItems(15, 25))

    // 2. QUESTION STUDENTS
    println("---------------------------------------")
    val studentList = listOf<Student>(
        Student(0, "James Miller", listOf("Math", "Sport", "Music")),
        Student(1, "Micheal Jordan", listOf("Math", "History")),
        Student(2, "Jessica Jones", listOf("Music", "Biology", "Chemistry")),
        Student(3, "Anthony Hopkins",  listOf("Drama", "Math", "Physics")),
        Student(4, "Natalie Portman", listOf("Drama", "Music", "Math", "Sport"))
    )
    val students = Students(studentList)
    val studentsLessons = students.getStudentLessons()
    println(studentsLessons)

    val mostLessonStudent = students.mostLessonStudent()
    println(mostLessonStudent)

    // 3. QUESTION ZOO
    println("---------------------------------------")
    val animalList = mutableListOf<Animal>(
        Animal(0, "Lion", "Mammals", "Savannah"),
        Animal(1, "Elephant", "Mammals", "Savannah"),
        Animal(2, "Tiger", "Mammals", "Jungle"),
        Animal(3, "Giraffe", "Mammals", "Savannah"),
        Animal(4, "Zebra", "Mammals", "Savannah"),
        Animal(5, "Panda", "Mammals", "Forest"),
        Animal(6, "Kangaroo", "Mammals", "Australia"),
        Animal(7, "Polar Bear", "Mammals", "Arctic"),
        Animal(8, "Horse", "Mammals", "Plains"),
        Animal(9, "Gorilla", "Mammals", "Forest")
    )
    val zoo = Zoo(animalList)
    println( zoo.getAnimals() )
    println( zoo.filterHabitat("Savannah") )


    // 4. QUESTION LIBRARY
    println("---------------------------------------")
    val bookList = mutableListOf<Book>(
        Book(0, "Martin Eden", "Jack London"),
        Book(1, "To Kill a Mockingbird", "Harper Lee"),
        Book(2, "1984", "George Orwell"),
        Book(3, "The Great Gatsby", "F. Scott Fitzgerald"),
        Book(4, "Pride and Prejudice", "Jane Austen"),
        Book(5, "Harry Potter and the Philosopher's Stone", "J.K. Rowling"),
        Book(6, "The Catcher in the Rye", "J.D. Salinger"),
        Book(7, "The Lord of the Rings", "J.R.R. Tolkien"),
        Book(8, "Animal Farm", "George Orwell"),
        Book(9, "The Hobbit", "J.R.R. Tolkien")
    )
    val library = Library(bookList)
    val newBook = Book(10, "Crime and Punishment", "Fyodor Dostoevsky")
    library.addBook(newBook)
    val getBooks = library.getBooks()
    println( getBooks )
    println( library.filterByAuthor("George Orwell") )

    // 5. QUESTION ONLINE SHOP
    println("---------------------------------------")
    val onlineShop = OnlineShop()

    val shirt = Product(0, "Shirt", 30.0)
    val dress = Product(1, "Dress", 50.0)
    onlineShop.addProduct(shirt)
    onlineShop.addProduct(dress)
    val getProducts = onlineShop.getProducts()
    println( getProducts )
    val totalPrice = onlineShop.totalPrice()
    println( totalPrice )

    onlineShop.removeProduct(shirt)
    onlineShop.clearBasket()
    println( onlineShop.getProducts() )

    val fastMarket = FastMarket()
    val meat = Product(2, "Meat", 8.99)
    val milk = Product(3, "Milk", 1.99)

    fastMarket.addProduct(meat)
    fastMarket.addProduct(milk)

    val marketPrice = fastMarket.totalPrice()
    println( marketPrice )

    val mealOrder = MealOrder()
    val hamburgerMenu = Product(15, "Hamburher Menu 2", 12.99)

    mealOrder.addProduct(hamburgerMenu)
    println( mealOrder.getProducts() )
    val mealOrderPrice = mealOrder.totalPrice()
    println(mealOrderPrice)
}