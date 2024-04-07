package soru4

class Book(val name: String, val author: String, val type: String) : Library() {

    //init fonksiyonu ile nesne oluşturulduğunda super class içerisindeki addBook fonksiyonu çağrılır.
    //Böylece nesne oluşturulduğunda book library'e eklenmiş olur.
    init {
        super.addBook(this)
    }

    //Any sınıfındaki toString metodu override edilerek sınıfın String olarak çıktısı verilmiştir.
    override fun toString(): String {
        return "Name:$name, Author:$author, Type:$type"
    }
}