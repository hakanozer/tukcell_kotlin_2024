package org.example.Task4

class Library {

    val booksOnLibrary= mutableListOf<Book>() // Book sınıfını parametre alarak, kütüpphanedeki kitapların bir listesi oluşuruldu

    fun addBook(book:Book){ // Yeni kitap ekleme fonksiyonu
        booksOnLibrary.add(book)
    }

    fun listBook():MutableList<Book>{ // Kitapları listeleme fonksiyonu
        return booksOnLibrary;
    }

    fun listBookByWriter(name:String):MutableList<Book>{ // Belirli bir yazarın litaplarını listeleyen bir liste geriye döndürür

        val listBookByWriter = mutableListOf<Book>()

        booksOnLibrary.forEach {
            if(it.writer==name){
                listBookByWriter.add(it)
            }
        }

        return listBookByWriter;

    }

}