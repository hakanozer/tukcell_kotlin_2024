///Bu Kotlin dosyası Turkcell Geleceği Yazanlar Kotlin 2024 ödev-2 için
///Umut Yusuf Çınar tarafından oluşturuldu.

/*
4. Bir kitap kütüphanesini temsil eden Library adında bir sınıf oluşturun. Bu sınıf,
kütüphanedeki kitapların bir listesini içermeli ve yeni kitapları eklemek ve mevcut
kitapları listelemek için metodlar içermelidir. Ayrıca, belirli bir yazarın kitaplarını
listelemek için bir fonksiyon ekleyin.

Soru Miras alma yapısına daha uygun olması için çeşitlendirin veya uyarlayın demiştiniz hocam.
O sebeple soruyu revize ediyorum:

Bir kitap kütüphanesini temsil eden Library adında bir sınıf oluşturun.
Bu sınıf, kurucu metottan girilen bir writerName isimli String tipinde bir değişken içermeli ve
kütüphanedeki kitapların bir listesini içermeli ve yeni kitapları eklemek ve
mevcut kitapları listelemek için metodlar içermelidir.
Library sınıfından miras alan Encyclopedia adında bir sınıf olmalı.
Bu alt sınıf serialNumber adında Int tipine sahip ve specialBookCover adında ve String tipinde
bir değişken içermeli.
Ayrıca Library sınıfı içerisine, belirli bir yazarın kitaplarını listelemek için bir fonksiyon ekleyin.
 */

package org.example.soru4
//Miras verebilmesi için open olarak niteliyorum.
open class Library() {
    //Aslında kitap ve yazarlar olduğu için bu soruyu map ile de anahtar değer çifti olarak çözebilirdik.
    //Ancak hem değiştirme imkanları hem de soruda öyle istendiği için listelerle kurgulayacağım hocam.
    var books: MutableList<String> = mutableListOf()
    var writers: MutableList<String> = mutableListOf()
    // Listeye kitap eklemek için metod oluşturuyorum.
    fun addBookToListWithWriter(book: String, writerName: String) {
        books.add(book)
        writers.add(writerName)
    }

    // Kitap silmek için metod
    fun removeBookFromListWithWriter(book: String, writerName: String) {
        books.remove(book)
        writers.remove(writerName)
    }

    // Mevcut kitapları listelemek için metod oluşturuyorum.
    fun listBooks() {
        println("Kitaplar:")
        for (book in books) {
            println(book)
        }
    }

    //Belirli bir yazarın kitaplarını listelemek için metod oluşturuyorum.
    //Map yerine soruda list istenildiği için ve
    //Oluşturduğum fonksiyonlar listelere parametreleri aynı anda ekleyip sildiği için
    //index kıyaslamasıyla bu metodu kurgulayabilirim.
    fun listBooksByWriter(writerName: String) {
        println("$writerName adlı yazarın kitapları:")
        for (index in books.indices) {
            if (writers[index] == writerName) {
                println(books[index])
            }
        }
    }
}

