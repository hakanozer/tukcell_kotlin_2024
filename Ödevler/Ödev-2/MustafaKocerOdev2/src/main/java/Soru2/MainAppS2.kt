package Soru2

fun main(){
    val ogrenci1 = Student("Ali", 101, mutableListOf("Matematik", "Fizik"))
    val ogrenci2 = Student("Ayşe", 102, mutableListOf("Türkçe", "Kimya"))
    val ogrenci3 = Student("Ahmet", 103, mutableListOf("Biyoloji", "Tarih","Edebiyat", "Müzik","Örnek Ders"))
    val ogrenci4 = Student("Fatma", 104, mutableListOf("Coğrafya", "İngilizce","Edebiyat", "Müzik","Örnek Ders", "Mantar Yemeği"))
    val ogrenci5 = Student("Mustafa", 105, mutableListOf("Edebiyat", "Müzik"))
    val ogrenci6 = Student("Zeynep", 106, mutableListOf("Felsefe", "Din Kültürü"))
    val ogrenci7 = Student("Mehmet", 107, mutableListOf("Bedava Ders", "Havuç Yeme"))
    val ogrenci8 = Student("Hatice", 108, mutableListOf("Örnek Ders", "Mantar Yemeği"))
    val ogrenci9 = Student("Esra", 109, mutableListOf("Geometri", "Almanca"))
    val ogrenci10 = Student("Burak", 110, mutableListOf("Muhasebe", "Programlama"))

    val ogrenciListesi : MutableList<Student> = mutableListOf()
    ogrenciListesi.add(ogrenci1)
    ogrenciListesi.add(ogrenci2)
    ogrenciListesi.add(ogrenci3)
    ogrenciListesi.add(ogrenci4)
    ogrenciListesi.add(ogrenci5)
    ogrenciListesi.add(ogrenci6)
    ogrenciListesi.add(ogrenci7)
    ogrenciListesi.add(ogrenci8)
    ogrenciListesi.add(ogrenci9)
    ogrenciListesi.add(ogrenci10)

    ogrenci1.ogrencilerinDersleriniListele(ogrenciListesi)

    println("-------------------")
    ogrenci1.enYuksekDersBul(ogrenciListesi)




}