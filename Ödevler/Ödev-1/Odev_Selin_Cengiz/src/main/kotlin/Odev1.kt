fun main() {

    //Soru 1
    //Çıktı [2, 4, 6, 2, 8, 94, 64, 4, 2]
    println(soru_1(arrayOf(2, 3, 4, 6, 2, 8, 3, 7, 94, 64, 4, 2, 9)))

    //Soru 2
    //Çıktı {c=1, a=2, d=3, e=1}
    println(soru_2(arrayOf('c', 'a', 'd', 'a', 'd', 'd', 'e')))

    //Soru3
    //Çıktı [zeliha, nalan, ali, selin]
    println(soru_3(listOf("selin", "ali", "nalan", "zeliha")))

    //Soru4
    //Çıktı [1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29]
    //Print içerisinde görmek istenilirse listeye çevirilebilir. Soruda dizi dendiği için böyle bıraktım.
    println(soru_4(1, 29))

    //Soru 5
    //Çıktı 5
    println(soru_5(arrayOf('c', 'a', 'd', 'a', 'd', 'd', 'e', 'A', 'B', 'E')))

    //Soru 6
    //Çıktı [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
    println(soru_6(48, ::isPrimeNumber))

    //Soru 7
    //Çıktı {Selin Ayten Cengiz=3, Turkcell Geleceği Yazanlar=3, Kotlin=1, Android Development=2}
    println(soru_7(arrayOf("Selin Ayten Cengiz", "Turkcell Geleceği Yazanlar", "Kotlin", "Android Development")))

    //Soru 8
    //Çıktı  {Selin Ayten Selin Cengiz=Selin, Turkcell Geleceği Yazanlar Turkcell=Turkcell, Kotlin=Kotlin, Android Android Development=Android, Selin Cengiz=Selin}
    println(
        soru_8(
            arrayOf(
                "Selin Ayten Selin Cengiz",
                "Turkcell Geleceği Yazanlar Turkcell",
                "Kotlin",
                "Android Android Development",
                "Selin Cengiz"
            )
        )
    )

    //Soru 9
    //Çıktı SELIN34 CENGIZSELIN211 CENGIZ
    println(soru_9("selin34 cengiz", "selin211 cengiz"))

    //Soru 10
    //Çıktı [apple, banana]
    println(soru_10(listOf("apple", "apple", "banana", "strawberry", "banana")))
}

//Filter fonksiyonu array içerisinde 2'ye tam bölünen yani çift sayıları tespit edip arka planda bunları listeye atma işlemini yapmaktadır.
//Arka planda filterTo adlı fonksiyonu listeye dönüştürmek için kullanır.
//Böylece istenen işlemi pratik bir şekilde filter fonksiyonu ile gerçekleştirebiliriz.
fun soru_1(array: Array<Int>): List<Int> = array.filter { it % 2 == 0 }

// GroupBy fonksiyonu ile her ayrı harfi key olarak, tekrarlayan elemanlarını ise value olarak liste tipinde alırız.
// Geri dönen map türününün value kısmını değiştirmek içinse map türüne özel olan mapValues fonksiyonunu kullanıyoruz.
// Bu fonksiyonla value kısmı tekrarlayan elemanların bir listesi olmak yerine, listenin uzunluğunu alır.
fun soru_2(array: Array<Char>): Map<Char, Int> =
    array.groupBy { it }.mapValues {
        it.value.size
    }


//Reversed fonksiyonu ile listenin elemanlarının sırası tersine çevirilebilir.
fun soru_3(list: List<String>): List<String> = list.reversed()


//Başlangıç ve bitiş değerleriyle bir range oluşturuyoruz.
//Daha sonrasında filter fonksiyonu ile tek sayıları buluyoruz.
//Filter fonksiyonu bize bir liste döndürdüğü için daha sonrasında diziye dönüştürme işlemini yapıyoruz.
fun soru_4(start: Int, end: Int): Array<Int> =
    (start..end).filter { it % 2 == 1 }.toTypedArray()

//Dizideki sesli harfler filter fonksiyonu yardımıyla bulunur.
//Harflerin karşılaştırılmasına kolaylık sağlaması için liste içerisinde contains methoduyla aranır.
//Daha sonra sesli harflerin sayısı için size döndürülür.
fun soru_5(array: Array<Char>): Int =
    array.filter { listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(it) }.size

//İstenilen sayıya kadar bir range oluşturulur daha sonrasında filter fonksiyonu ile asal olan sayılar listeye atanır.
//IsPrimeNumber high order function olarak tanımlanmıştır.
fun soru_6(border: Int, isPrimeNumber: (Int) -> Boolean): List<Int> =
    (2..border).filter { isPrimeNumber(it) }

//6.soru için asal sayı kontrolü yapan fonksiyon
fun isPrimeNumber(number: Int): Boolean {

    for (i in 2 until number) {
        if (number % i == 0)
            return false
    }
    return true
}

//Bu fonksiyonda her bir dizi elemanının kaç kelime barındırdığını görebilmek için associateWith kelime anahtarı ile map yapısı oluşturuyoruz. Map yapısı gözlemlenebilirlik açısından gereklidir.
//Daha sonra split fonksiyonu ile boşlukların algılanıp kelimelerin ayrıştırılmasını sağlıyoruz.
//Son olarak size diyerek kaç kelime olduğunu görebiliriz.
fun soru_7(array: Array<String>): Map<String, Int> =
    array.associateWith { it.trim().split(" ").size }

//AssociateWith ile dizinin elemanları bir map'e dönüştürülür. Key değerleri otomatik olarak dizinin elemanlarına eşitlenir.
//Split fonksiyonu ile dizi elemanı kelimelere ayrılır.
//GroupingBy ve eachCount fonksiyonları ile kelimelerin kaç kere tekrar ettiğini gösteren bir map elde ederiz.
//Daha sonrasında run bloğu ile elde ettiğimiz mapteki value'su en fazla olan döndürülür.
//First methodu ile aynı sayıda tekrar edilen kelime varsa ilkini alması sağlanır.
fun soru_8(array: Array<String>): Map<String, String> {
    return array.associateWith {
        it.trim().split(" ").groupingBy { it }.eachCount().run {
            return@run filterValues { it == values.maxOrNull() }
        }.keys.first()
    }
}

//Stringler içerisindeki boşluk ve sayılar replace fonksiyonu ile kaldırılır.
//Daha sonrasında stringlerin uzunlukları karşılaştırılarak harf sayınısına bakılır.
//Eşit ise uppercase fonksiyonu ile büyük harf birleştirmesi yapılır.
fun soru_9(string1: String, string2: String): String {
    val string1Length = string1.replace(" ", "").replace(Regex("\\d+"), "").length
    val string2Length = string2.replace(" ", "").replace(Regex("\\d+"), "").length

    return if (string1Length == string2Length) {
        string1.uppercase().plus(string2.uppercase())
    } else {
        string1.plus(string2)
    }
}

//Listeyi set ile karşılaştırmak için mutableSet oluşturulur.
//List içerisinde bulunan elemanın set içerisinde bulunup bulunmadığı  kontrol edilir.
//Kontrol remove fonksiyonu ile sağlanır. Remove fonksiyonu hem set içerisinde elemanın olup olmadığını kontrol eder hem de set içerisinden elemanı siler.
//Set içerisinden elemanı silmemizin sebebi aynı öğelerin eşleşmesini önlemektir.
fun soru_10(list: List<String>): List<String> {
    val set = list.toMutableSet()

    return list.filterNot {
        set.remove(it)
    }
}








