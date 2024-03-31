package org.example

fun main() {
    val size=70 // Dizinin kaç harften oluştuğunu alan parametre
    val charsList= mutableListOf<Char>() // İlk liste oluşturdum, ekleme yapabilmek için

    repeat(size){
        charsList.add(generateRandomChar()) // Rastgele harfler listeye ekleniyor
    }

    val charsArray=charsList.toTypedArray() // Soruda dizi olarak istendiği için liste diziye çevirildi

    countLetters(charsArray)

}

fun countLetters(letters:Array<Char>):Map<Char,Int>{
    val dictionary= letters.groupBy { // Alınan arrayin elemanları gruplandırılıyor ve kendi içlerinde sayıyor
        it
    }.mapValues { it.value.size }

    return dictionary // Her elemandan kaç tane olduğunun map'i dönüyor

}

fun generateRandomLetters(count:Int):Char{ // Rastgele harfler oluşturmak için bir fonksiyon
    val characters=('a'..'z') // Harflerin aralığı alınıyor ve sıralı değil de karıştırılmış bir şekilde alınması sağlanıyor
    return characters.random()
}