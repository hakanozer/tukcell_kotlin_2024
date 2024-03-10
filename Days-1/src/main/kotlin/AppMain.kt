fun main() {
    // One line comment
    /*
    * Multiline comment
    * */

    // Değişken oluşturma
    // var, val
    // var -> bir değişkenin değerinin daha sonra değiştirilmesi durumu
    // val -> sabit değere sahip bir değişken kurma

    // String Type
    val userEmailOrUsurName = "ali01"
    val name = "Erkan"
    val surname = "Bilmem"
    val stAge = "30"
    val isFenerbahce:String = "true"
    var city = "İstanbul"
    city = "Ankara"
    val concat = "Adı: $name Soyadı: $surname"

    println(userEmailOrUsurName)
    println("Sn. $name")
    println("Count: ${name.count()}")

    println("Adı: $name Soyadı: $surname")
    println(concat)

    //val nameAli = "Ali"
    //sendString("Ali")
    //sendString(nameAli)

    val namex = "Serkan"
    val namey = "Serkan"

    // Int -> Tam sayı
    // Orta seviye tam sayı
    val num1:Int = 2147000000

    // Yüksek seviye tam sayı
    val num2:Long = 999999999999999999

    // Düşük seviye
    val num3: Short = 32500

    // Daha küçük seviye tam sayılar
    val num4:Byte = 127


    // True - False
    // Karar kontrol gibi alanlarda kullanılır.
    var status1 = true

    // Ondalıklı değerler
    // Double -> büyük ondalıklı değerler
    val num5 = 10.5
    // Float -> orta seviye ondalıklı değerler
    val num6 = 10.5f

    // Any Type
    var obj:Any = true

    if (obj is String) {

    }

    if (obj is Boolean) {
        val status3 = obj.toString().toBoolean()
        println("Boolean: $obj")
    }

    //  String to Int
    val st1 = "40"
    val intSt1 = st1.toInt()
    println(intSt1 + 10)


}