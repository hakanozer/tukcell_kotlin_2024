package Soru_2

fun main() {

    val students = listOf(
        Student("Ayşe",255467, listOf("Bilgisayar Grafikleri","Görsel Programlama","Algoritma Analizi", "Nesneye Yönelik Programlama")),
        Student("Zehra",879012 , listOf("Python Programlama","Nesneye Yönelik Programlama","Algoritma Analizi")),
        Student( "Kenan",345378, listOf("Veri İletişimi", "İşletim Sistemleri", "Mikroişlemciler","Yazılım Sınaması","Yapay Zeka")),
        Student("Emre", 256130, listOf("Yapay Zeka","Bilgisayar Grafikleri")),
        InternationalStudent("Batuhan",457684 , listOf("Veri Yapıları", "Yapay Zeka","Bilgisayar Ağları"),"Türkiye"),
        InternationalStudent("David",509524 , listOf("Veri İletişimi", "Yapay Zeka","Bilgisayar Ağları", "Algoritma Analizi"),"Fransa")

    )

    val student = Student()
    val ogrenciMap = student.dersleriListele(students)
    for (it in ogrenciMap){
        println("${it.key} --> ${it.value}")
    }

    val maxOgrenci = student.enFazlaDerseSahipOgrenci(students)
    if (maxOgrenci != null) {
        println("En çok ders alan öğrencinin adı: ${maxOgrenci.name} --> Ders sayısı: ${maxOgrenci.courses.size}")
    }

    val student1 = InternationalStudent()
    val ogrenciUlkeMap = student1.dersleriListele(students)
    for (it in ogrenciUlkeMap){
        println("${it.key} --> ${it.value}")
    }
}