
/*
1. Bir dizideki çift sayıları bulan ve bunları bir listeye ekleyen bir Kotlin fonksiyonu
yazın.
*/

fun main() {

    val numberList = arrayOf<Double>(1.0,25.0,32.5,43.6,45.1,46.8)  // liste oluşturuldu
    val evenNumbers = getEvenNumbers(numberList)

    println(evenNumbers)
}

fun getEvenNumbers(list:Array<Double>) : List<Double>{

    // parametre olarak gelen listenin elemanlarını filtreleyerek istedğimiz şartları sağlayan elemanları aldık
    val evenNumberslist =list.filter { num->
        Math.floor(num) % 2.0 == 0.0
    }

    return  evenNumberslist
}
