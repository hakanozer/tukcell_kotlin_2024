package soru4

class PersonalLibrary : Library() {
    override fun addBook(title: String, author: String) {
        super.addBook(title, author)
        println("Özel kütüphaneye : $title kitabı eklendi.")
    }
}