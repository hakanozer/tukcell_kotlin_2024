
/*
Belirli Bir Aralıktaki Tüm Tek Sayıları İçeren Bir Dizi Oluşturan Fonksiyon
yazın. Başlangıç ve bitiş değerleri kullanıcı tarafından sağlanmalıdır
*/

fun main() {


    println(getOddNumbers(start = 25, end = 53))
}

fun getOddNumbers(start:Int,end:Int) : MutableList<Int>{

    val oddNumbers = mutableListOf<Int>()

    // başlangıçtan bitiş sayısına kadar olan sayıları döndürüp tek ise listeye ekliyoruz
    for (num in start until end+1 ){
        if (num % 2 == 1){
            oddNumbers.add(num)
        }
    }

    return oddNumbers
}