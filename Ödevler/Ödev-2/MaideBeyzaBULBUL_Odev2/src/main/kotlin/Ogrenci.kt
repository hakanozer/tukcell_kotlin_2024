open class kisiler (val adi: String, val no: Int)

class ogrenci(name: String, number: Int, val dersler: List<String>) : kisiler(name, number)

open class ogrencilistesi {
    protected val ogrenciler = mutableListOf<ogrenci>()

    fun ogrenciEkle(student: ogrenci) {
        ogrenciler.add(student)
    }

    open fun dersler(studentNumber: Int): List<String>? {
        val ogrenci = ogrenciler.find { it.no == studentNumber }
        return ogrenci?.dersler
    }

    open fun enCokDersAlanOgrenci(): ogrenci? {
        return ogrenciler.maxByOrNull { it.dersler.size }
    }
}