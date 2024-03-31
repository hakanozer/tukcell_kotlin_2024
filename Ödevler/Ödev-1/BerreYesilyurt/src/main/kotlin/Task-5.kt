package org.example

fun main() {

    val size=50 // Listenin kaç karakter barındıracağı
    val charList = mutableListOf<Char>() // Dizilere eleman ekleme işlemi sonradan yapılamadığı için ilk olarak elemanları Liste'ye ekledim

    repeat(size){
        charList.add(generateRandomChar()) // Belirlenen sayıda rastgele harfler listeye ekleniyor
    }

    countLetters(charList) // Sesil harf sayısını hesaplayan fonksiyonun çağırılması
}

fun generateRandomChar(): Char { // a-z aralığında rastgele bir harf üretir
    val characters = ('a'..'z')
    return characters.random()
}

fun countLetters(charList:MutableList<Char>):Int{
    var charCount=0 // Sesli harflerin sayısı, başkangıçta 0
    val charArray=charList.toTypedArray() // Değişken olarak alınan listenin(charList'in) içeriğini charArray'e kopyalanıyor

    charArray.forEach { // Sesli harf varsa sesli harf sayacı bir artıyor
        print(it)
        if(it=='a' || it=='e' || it=='i' || it=='o' || it=='u' ){
            charCount++
        }
    }
    return charCount // Kaç adet sesli harf olduğunun sonucunu döner
}