package org.example
//4. soru için extra class
class Book(val title: String, val authorName: String) {
    override fun toString(): String {
        return "$title by $authorName"
    }
}
