fun main() {

    //Soru-1
    val intList= listOf(10,20,30,3,5,7,9,10,4)
    val result=intList.filter { it%2==0 }
    println(result)

    //Soru-2
    val list = arrayOf('ş','e','v','v','a','l','ç','e','l','i','k', 'k','ç','ş')

    val harfSayilari = harfleriSayaci(list)
    println("Dizideki Harflerin Sayıları: $harfSayilari")

    //Soru-3
    val listNumber=mutableListOf("bir", "iki", "üç", "dört","beş","altı","yedi")
    println(tersineCevirme(listNumber))

    //Soru-4
    println(tekSayiDizisi(2,19))


    //Soru-5
    val dizi= arrayOf<Char>('a','e','i','o','u','a','r','d','j','e','i','o','u','h')
    println(sesliHarfDizisi(dizi))

    //Soru-6
    val num1=48
    val asalList=asalSayiBulma(num1)
    println("$num1'e kadar olan asal sayılari içeren liste: $asalList")

    //Soru-7
    val stDizi= listOf(" şevval çelik yazılım mühendisliği 4. sınıf öğrencisiyim")
    val kelimeSayisi=kelimeSayisiBulma(stDizi)
    println("Bu dizideki kelime sayısı:$kelimeSayisi")


    //Soru-8
    val dizi2 = arrayOf("kotlin", "java", "C#", "react", "flutter", "react","flutter", "kotlin", "kotlin" )
    val tekrarEdenKelime = tekrarlananKelimeSayisiniBulma(dizi2)
    println("En sık tekrar eden kelime: $tekrarEdenKelime")

    //Soru-9
    val ad="şevval"
    val soyad="çelikk"
    println(birlestirme(ad,soyad))

    //Soru-10


    val list1 = listOf("ayşe", "ahmet", "şevval", "elif")
    val set = setOf("ahmet", "ayşe", "enes")

    val fark = farkAlma(list1, set)

    println("Listede olup sette olmayan öğe: $fark")
}


//Soru-2
fun harfleriSayaci(charList: Array<Char>): Map<Char, Int> {
    val harfSayilari = mutableMapOf<Char, Int>()

    for (harf in charList) {
        harfSayilari[harf] = harfSayilari.getOrDefault(harf, 0) + 1
    }

    return harfSayilari
}

//Soru-3
fun tersineCevirme(stList:List<String>):List<String>{
    val reserveList= stList.reversed()
    return reserveList
}

//Soru-4
fun tekSayiDizisi(first:Int,last:Int):List<Int> {
    return (first..last).filter { it % 2 != 0 }
}


//Soru-5
fun sesliHarfDizisi(dizi:Array<Char>):Int{
    val sesliHarfler = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    var sesliHarfSayisi= 0
    for (harf in dizi){
        if(harf in sesliHarfler){
            sesliHarfSayisi++
        }

    }
    return sesliHarfSayisi

}

//Soru-6
fun asalSayiBulma(num:Int):List<Int>{
    val asalSayiList= mutableListOf<Int>()

    for (i in 2 until num ){
        var asal=true
        for(x in 2 until i){
            if(i%x==0){
                asal=false
                break
            }
        }
        if(asal){
            asalSayiList.add(i)
        }
    }
    return  asalSayiList
}

//Soru-7
fun kelimeSayisiBulma(dizi:List<String>):Int{
    var kelimeSayisi = 0

    for (kelime in dizi) {
        val kelimeler = kelime.trim().split("\\s+".toRegex())
        //println(kelimeler)
        kelimeSayisi += kelimeler.size
    }
    return kelimeSayisi
}


//Soru-8
fun tekrarlananKelimeSayisiniBulma(dizi: Array<String>): String{
    val frekanslar = mutableMapOf<String, Int>()

    for (kelime in dizi) {
        frekanslar[kelime] = (frekanslar[kelime] ?: 0) + 1
    }
    println(frekanslar)

    //maxByOrNull:en yüksek frekansa sahip ögeyi döndürür, boşsa "en sık tekrar eden kelime yoktur" döndürür
    val enSikTekrarKelime = frekanslar.maxByOrNull { it.value }?.key ?: "en sık tekrar eden kelime yoktur."

    return enSikTekrarKelime
}

//Soru-9
fun birlestirme(st1: String, st2: String):String {
    if (st1.length == st2.length) {
        return st1.toUpperCase() + st2.toUpperCase()
    } else {
        return st1 + st2
    }
}

//Soru-10

fun farkAlma(list: List<String>, set: Set<String>): List<String> {
    val set2 = HashSet(set)
    return list.filterNot { set2.contains(it) }
}




