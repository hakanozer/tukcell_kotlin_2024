package org.example

fun main() {
    
    val array= arrayOf<String>("Java","oldukça","önemli bir","yazılım dilidir") // Kelime saysı hesaplanacak olan dizi

    countWords(array) // Fonksiyonun çağırılması
    
}

fun countWords(array:Array<String>):Int{
    var counter=0 // Kelime sayısını tutan parametre

    array.forEach { // Her elemanın üzerinde döner
        if(it.contains(" ")){ // Eğer boşluk içeriyorsa, bu tek kelime değildir
            counter+=it.split(" ").size // Kaç kelime varsa onu sayaca ekler
        }
        else{ // Eğer boşluk yoksa o tek kelimedir ve sayac bir artar
            counter++
        }
    }

    return counter // Kelime sayısını döner
}