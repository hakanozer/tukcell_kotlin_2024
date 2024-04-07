package org.example.soru_4

open class Book(val title: String, val author: String) {
    open fun displayDetails() {
        println("Başlık: $title, Yazar: $author")
    }
}