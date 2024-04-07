package Soru4

class Library(val kitaplar : MutableList<Book>) {


    fun kitapEkle(kitap: Book){
        this.kitaplar.add(kitap)
        println("Kitabınız başarıyla eklenmiştir")
    }

    fun kitaplariListele(){
        println("Kütüphanedeki kitaplar : ")
        this.kitaplar.forEach { kitap->
            println("Kitabın adi: ${kitap.kitapIsmi}"+
            ", kitabın yazari: ${kitap.yazarIsmi}, kitabin sayfa sayisi: ${kitap.sayfaSayisi}")
        }
    }
}