fun tekSayilarolustur(baslangic: Int, bitis: Int): List<Int> {
    val tekSayilar = mutableListOf<Int>()
    var i = baslangic

    while (i <= bitis) {
        if (i % 2 != 0) {
            tekSayilar.add(i)
        }
        i++
    }
    return tekSayilar
}

fun main() {
    println("Başlangıç değerini girin:")
    val baslangic = readLine()?.toIntOrNull()
    if (baslangic == null) {
        println("Geçersiz değer")
        return
    }

    println("Bitiş değerini girin:")
    val bitis = readLine()?.toIntOrNull()
    if (bitis == null) {
        println("Geçersiz değer")
        return
    }

    val tekSayilarListesi = tekSayilarolustur(baslangic, bitis)

    println("Tek sayılar: $tekSayilarListesi")
}