class string {

    // bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan fonksiyon

    fun letter_again (dizi: MutableList<String>): Map<Char, Int> {

        val map = mutableMapOf<Char, Int>()
        for (item in dizi) {
            for (char in item) {
                if (char.isLetter()) {
                    val harf_kücültme = char.lowercaseChar()
                    map[harf_kücültme] = map.getOrDefault(harf_kücültme, 0) + 1
                }
            }
        }
        return map
    }

    // Listeyi tersine çevirme fonksiyonu

    fun tersListe(arrayList: ArrayList<String>): ArrayList<String> {
        val tersListe = ArrayList<String>()

        for (i in arrayList.size - 1 downTo 0) {
            tersListe.add(arrayList[i])
        }

        return tersListe
    }

    // Sesli harf hesaplayan fonksiyon
    // bir dizideki her bir harfin kaç kez tekrarlandığını hesaplayan fonksiyon

    fun vowel (dizi: MutableList<String>): Map<Char, Int> {

        val vowels = "aeiouöü"
        val map = mutableMapOf<Char, Int>()
        for (item in dizi) {
            for (char in item) {
                if (char.isLetter()) {
                    val harf_kücültme = char.lowercaseChar()
                    if (harf_kücültme in vowels )
                    map[harf_kücültme] = map.getOrDefault(harf_kücültme, 0) + 1
                }
            }
        }
        return map
    }

    // Kelime sayısını hesaplayan fonksiyon
    fun words (dizi : ArrayList<String>): Map<String, Int>
    {
        val map = mutableMapOf<String, Int>()

        for (i in dizi)
        {
            val word = i.split("\\s+".toRegex())
            for (item in word)
            {
                if(item.isNotEmpty())
                {
                    map[item] = map.getOrDefault(item, 0) + 1
                }
            }
        }
        return map

    }

    // Tekrar eden kelimeyi hesaplayan fonksiyon

    fun repetitive ( dizi : ArrayList<String> ): String?
    {
        if(dizi.isEmpty())
        {
            return null
        }
        val tekrar_eden = mutableMapOf<String, Int>()

        dizi.forEach{
            var array = it.replace(Regex("\\s+"),"").toLowerCase()
            tekrar_eden[array] = tekrar_eden.getOrDefault(array, 0) + 1
        }

        return tekrar_eden.maxByOrNull { it.value }?.key
    }

    // Dizileri birleştiren fonksiyon

    fun birlestirme(s1: String, s2: String): String {
        val birles = s1.replace(" ", "") + s2.replace(" ", "")
        return if (s1.length == s2.length) {
            birles.toUpperCase()
        } else {
            birles
        }
    }

    // List ile set arasındaki farkı bulan fonksiyon

    fun different(liste: List<String>, set: MutableSet<String>): Set<String> {

        val dizi = liste.toSet()
        val fark = dizi.subtract(set)
        return fark
    }
    
}