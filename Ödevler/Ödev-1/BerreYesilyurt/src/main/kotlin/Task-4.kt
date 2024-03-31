package org.example

fun main(){
    oddNumbers()
}

fun oddNumbers():Array<Int>{
    val oddNumbersList= mutableListOf<Int>() // İlk bir liste tanımlandı

    for(i in 0..100){ // Belirli aralıktaki tek sayılar tanımlanan listeye eklendi
        if(i%2==1){
            oddNumbersList.add(i)
        }
    }

    val oddNumbersArray=oddNumbersList.toTypedArray() // Listedeki elemanlar dizi'ye aktarıldı. Soruda tip olarak dizi istendiği için listedeki elemanları diziye kopyaladım. Çünkü başla dizi yapsaydım, diziye ekleme yapamayacaktım

    return oddNumbersArray // Tek sayıların toplandığı diziyi döndürdüdm
}