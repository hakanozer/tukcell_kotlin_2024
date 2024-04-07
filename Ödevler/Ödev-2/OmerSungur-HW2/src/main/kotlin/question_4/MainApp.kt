package question_4

fun main() {
    // Book Instance
    val donQuixote = Book("Don Quixote", "Miguel de Cervantes")
    val warAndPeace = Book("War and Peace", "Leo Tolstoy")
    val crimeAndPunishment = Book("Crime and Punishment", "Fyodor Dostoevsky")
    val annaKarenina = Book("Anna Karenina", "Leo Tolstoy")
    val mathBook = Book("Fundamentals of University Mathematics", "Colin McGregor")

    // Library Instance
    val library = Library(listOf(donQuixote, warAndPeace, crimeAndPunishment, annaKarenina))

    // Print book list
    library.printBookList()
    println()

    // Filter book by author
    library.filterBookByAuthor("Leo Tolstoy")
    println()

    // New Book Instance
    val theAdventuresOfHuckleberryFinn = Book("The Adventures of Huckleberry Finn", "Mark Twain")
    val invisibleMan = Book("Invisible Man", "Ralph Ellison")

    // Add new books in Library
    library.addBook(listOf(theAdventuresOfHuckleberryFinn, invisibleMan))

    // Print book list
    library.printBookList()
    println()

    // Collage Student Instance
    val student1 = CollageStudent("Leo", 200)
    val student2 = CollageStudent("Matthew", 201)

    // University Library Instance
    val universityLibrary = UniversityLibrary(listOf(mathBook), listOf(student1, student2))

    // Print book list
    universityLibrary.printBookList()
    println()

    universityLibrary.rewardStudentsOfTheMonth(student1)
}