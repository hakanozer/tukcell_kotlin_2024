import kotlin.random.Random

fun main(){
    val randomNumberArray = Array(50) { Random.nextInt(0, 101) }
/*// Soru 1 deneme
 println("Rastgele Sayılar:")
    randomNumberArray.forEach { println(it) }

     val myTest = soru1(randomNumberArray)

    myTest.forEach {
        print(it.toString()+ "  ")
    }
 */


/*// Soru 2 deneme
val a = "selamlar naber ben MmuUsS tTaAfF aA"

    var myTest2 = soru2(a)
    myTest2.forEach { k, v ->
        println("$k: harfinden $v tane")
    }
 */

  /*
    // Soru 3 deneme
    val listeInt = listOf(1, 2, 3, 4, 5)
    val listeStr = listOf("selam","naber","deneme","yapıyorum","bugün","iyiyim")

    var temp3 = soru3(listeInt)
    var temp3ve2 = soru3(listeStr)

    temp3.forEach {
        print(it.toString()+ " : : ")
    }
    println("--------------------")
    temp3ve2.forEach {
        print(it + " : : ")
    }

   */

/*
// soru 4 deneme

    val temp4 = soru4(10,21)
    temp4.forEach {
        print(it.toString()+ " :: ")
    }
 */

/*
// Soru 5 deneme
   var temp5 = "4 tn e hehe merhaba okoz oldu ulu kurt ağladi aa ee cc"
    println("Toplamda sesli harf sayisi ${soru5(temp5)}")
 */


/*
// Soru 6 deneme
    var temp6 = soru6(1000)
    temp6?.let {
        it.forEach { sayi ->
            println(sayi)
        }
    }
    println(temp6!!.size)
 */


/*
// soru 7 deneme
var temp7 = "Uzun, ince bir yoldayım " +
        "Gediyorum gündüz gece " +
        "Bilmiyorum ne hâldeyim " +
        "Gediyorum gündüz gece " +
        "Uzun, ince bir yoldayım " +
        "Gediyorum gündüz gece " +
        "Bilmiyorum ne hâldeyim " +
        "Gediyorum gündüz gece " +
        "Gündüz gece " +
        "Gündüz gece " +
        "Gündüz gece, hey " +
        "Dünyaya geldiğim anda " +
        "Yörüdüm aynı zemanda " +
        "İki gapılı bir handa " +
        "Gediyorum gündüz gece"


println(soru7(temp7))
 */

/*
// soru 8 deneme
    var temp8 = "Uzun, ince bir yoldayım " +
            "Gediyorum gündüz gece " +
            "Bilmiyorum ne hâldeyim " +
            "Gediyorum gündüz gece " +
            "Uzun, ince bir yoldayım " +
            "Gediyorum gündüz gece " +
            "Bilmiyorum ne hâldeyim " +
            "Gediyorum gündüz gece " +
            "Gündüz gece " +
            "Gündüz gece " +
            "Gündüz gece, hey " +
            "Dünyaya geldiğim anda " +
            "Yörüdüm aynı zemanda " +
            "İki gapılı bir handa " +
            "Gediyorum gündüz gece"

    println("Soru 8 cevap : ${soru8(temp8)}")
 */


   /*
   // soru 9 deneme
    var temp9 = "selam ben mustafa kocer hah."
    var temp92 = "kola sağlığımıza zararlıdır."
    println(soru9(temp9, temp92))
    println(temp92.length)
    println(temp9.length)
    */


    /*
    // soru 10 deneme
    val intList: List<Int> = listOf(9,5,4,101,102,103,104,105,106,107,108,109,110,1,2,3,4,5,6,7,8,9,10,100,101,102,103,104,105,106,107,108,109,110)

var temp10 = soru10(intList)
    temp10.forEach {
        print("$it - ")
    }

    println("\n\n")

    var strList : List<String> = listOf("cengiz","mihriban","mustafa","kocer","mehmet","tagil","mustafa","hakan","calhanoglu","cengiz","under","mike","tyson","ifbb","pro","mike","mihriban")
    var temp102 = soru10(strList)
    temp102.forEach {
        print("$it - ")
    }
     */
}// main bitis


fun soru1(array: Array<Int>): List<Int>{
    val evenNums: MutableList<Int> = mutableListOf()

    array.forEach { sayi ->
        if(sayi%2 == 0){
            evenNums.add(sayi)
        }
    }

    return evenNums
}


fun soru2(string: String): Map<String,Int>{
    val harfHesaplaMap: MutableMap<String, Int> = mutableMapOf()

    string.forEach {harf ->
        // eğer boşluk işareti varsa harf olmadığı için geç
      if( !harf.toString().equals(" ")){
          // eğer o harfi içermiyorsa yeni bir key-Value yarat
          if( !harfHesaplaMap.containsKey(harf.toString())){
              harfHesaplaMap.put(harf.toString(),1)
          }
          // eğer o harfi daha onceden bulmussa değerini 1 arttır
          else{
              harfHesaplaMap[harf.toString()] = harfHesaplaMap[harf.toString()]!! +1
          }
      }
    }
    return harfHesaplaMap
}


fun <T> soru3(list: List<T>): List<T>{
    val mutableList : MutableList<T> = mutableListOf()

    // listenin sonundan baslayarak, mutable listeme ekliyorum
    for ( i  in list.size-1 downTo 0 step 1){
        mutableList.add(list[i])
    }

    val myReturn = mutableList.toList()
    return myReturn
}

fun soru4(altSinir: Int, ustSinir: Int): Array<Int>{
    var temp = 0
    var myAltSinir = altSinir
    var myUstSinir = ustSinir
    // eğer alt sinif ile üst sinif yanlış verilmişse diye kontrol ediyorum
    if(ustSinir < altSinir){
       temp = myUstSinir
        myUstSinir = myAltSinir
        myAltSinir = temp
    }

    temp  = myAltSinir
    val tekSayiListesi : MutableList<Int> = mutableListOf()

    if (temp % 2 == 0){
                // cift oluyor bir arttırıp 2 2 ekle
                temp +=1
            }


    // temp burada tek sayi
    while (temp <= ustSinir){
        tekSayiListesi.add(temp)
        temp +=2
        // boylelikle if kontorlüne gerek kalmadan bir sonraki tek sayiya geçebilecek
        }


    val returnArray = tekSayiListesi.toTypedArray()
    return returnArray
}


fun soru5(string: String): Int{
    var sesliHarfSayisi = 0

    string.forEach { harf->

        when(harf.toString()){
            "a" -> sesliHarfSayisi++
            "e" -> sesliHarfSayisi++
            "i" -> sesliHarfSayisi++
            "o" -> sesliHarfSayisi++
            "u" -> sesliHarfSayisi++
        }
    }
    return sesliHarfSayisi
}

fun soru6(limit: Int): MutableList<Int>?{
    val asalSayiListesi : MutableList<Int> = mutableListOf()

    if (limit < 2 ){
        return null
    }

    var isPrimeNum : Boolean
    for (sayi in 2 until limit){
        isPrimeNum = true

        for (bolen in 2 until (sayi/2)+1){
            // sayinin yarısına kadar gitmem yeterli, ondan üstü zaten bolemez
            if (sayi % bolen == 0){
                isPrimeNum = false
                break
            }
        } // bolen for bitis

        if (isPrimeNum ){
            asalSayiListesi.add(sayi)
        }

    }// sayi for bitis

    return asalSayiListesi
}

fun soru7(string: String) : Int{
    // bosluğa göre ayırıp saydırıyorum
    var kelimeListesi = string.split(" ")
    /*
    kelimeListesi.forEach {
        println(it +"-")
     */
    return kelimeListesi.size
}


fun soru8(string: String): String{
    val kelimeHesaplaMap: MutableMap<String, Int> = mutableMapOf()
    var ayrilmisKelime = string.split(" ")

    val temizKelimeListesi : MutableList<String> = mutableListOf()
    var temizKelime = ""

    // , ! . gibi şeylerle biten kelimeleri de aynı sayması için bu işaretleri içeren
    // kelimelerden, o işaretleri düşüyorum
    ayrilmisKelime.forEach {
        temizKelime = it
        if( !temizKelime.last().isLetterOrDigit()){
            temizKelime = temizKelime.dropLast(1)
        }
        temizKelimeListesi.add(temizKelime)
    }

    temizKelimeListesi.forEach { kelime ->
        if( !kelimeHesaplaMap.containsKey(kelime)){
            kelimeHesaplaMap.put(kelime,1)
        }
        // eğer o kelime'yi daha onceden bulmussa değerini 1 arttır
        else{
            kelimeHesaplaMap[kelime] = kelimeHesaplaMap[kelime]!! +1
        }
    }// temizkelimeMap foreach

    var maxKelimeSayi = 0
    var maxKelime = ""

    kelimeHesaplaMap.forEach { k,v ->
        // en çok tekrarlanan kelimeyi bul
        if(maxKelimeSayi < v){
            maxKelime = k
            maxKelimeSayi = v
        }
    }

 /*
 // kelime kontrolü
    kelimeHesaplaMap.forEach { k,v ->
        println("Kelime: $k , tekrar : $v")
    }
  */

    return maxKelime
}


fun soru9(string: String, string2: String): String{

    val birinciSize = string.length
    val ikinciSize = string2.length
// ayni lenght'de değillerse direkt birleştirip döndür
    if (birinciSize != ikinciSize){
        return string+" "+string2
    }

    return string.uppercase()+" "+string2.uppercase()
}



fun <T> soru10(list: List<T>): MutableList<T> {
    val kelimeMap: MutableMap<T, Int> = mutableMapOf()
    val farkListesi : MutableList<T> = mutableListOf()

    list.forEach {eleman ->
        if( !kelimeMap.containsKey(eleman)){
            kelimeMap.put(eleman,1)
        }
        // eğer o eleman'ı daha onceden bulmussa değerini bu liste ile set arasındaki farkımız olacak elemandır.
        else{
            farkListesi.add(eleman)
        }
    }

    return farkListesi
}