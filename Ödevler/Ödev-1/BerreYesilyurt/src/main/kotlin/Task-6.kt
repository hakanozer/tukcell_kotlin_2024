package org.example

fun main() {

    primeNumber(1,50) // Başlangıç ve bitiş değerleri verilen fonksiyonun çağırılması

}

fun primeNumber(start:Int,end:Int):MutableList<Int>{

    val allNumbersList= mutableListOf<Int>() // Belirli aralıktaki tüm sayılar
    val primeNumbersList= mutableListOf<Int>() // Aralıktaki asal sayılar
    var counter=0

    for(i in start..end){ // Bize verilen aralıktaki sayıları listeye ekleyen döngü
        allNumbersList.add(i)
    }

    allNumbersList.forEach { // Her eleman üzerinde döner
        counter=0

        for(i in 2..it-1){ // Her eleman, eğer bir kere bile bir sayıya bölündüyse asal sayı değildir. 1'den başlatıp verilen sayıdan önce bitirdim ki, o sayı 1 ve kendilerine bölünemesin
            if(it%i==0){
                counter++
            }
        }

        if(counter==0){ // O sayı hiçbir bölene bölünemezse asal listeye ekle
            primeNumbersList.add(it)
        }
    }

    return primeNumbersList // Asal listeyi döndür

}