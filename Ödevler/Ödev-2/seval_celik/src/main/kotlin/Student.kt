class Student(val ogrenciAd: String, val ogrenciNumara: Int, val ogrenciDers: List<String>) {
    fun dersleriListele() {
        println("Öğrenci: $ogrenciAd, Numara: $ogrenciNumara")
        println("Aldığı Dersler:")
        for (ders in ogrenciDers) {
            println("- $ders")
        }
    }

    fun enYuksekDersSayisinaSahipOgrenciyiBul(ogrenciler: List<Student>): Student? {
        var enYuksekDersSayisi = 0
        var enYuksekDersliOgrenci: Student? = null

        for (ogrenci in ogrenciler) {
            if (ogrenci.ogrenciDers.size > enYuksekDersSayisi) {
                enYuksekDersSayisi = ogrenci.ogrenciDers.size
                enYuksekDersliOgrenci = ogrenci
            }
        }

        return enYuksekDersliOgrenci
    }


}