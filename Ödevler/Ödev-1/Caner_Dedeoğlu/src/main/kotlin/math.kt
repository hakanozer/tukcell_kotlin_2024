class math {


    // Çift sayıları döndüren fonksiyon

    fun evenNumbers(dizi: MutableList<Int>): MutableList<Int> {
        val evenNumbers = mutableListOf<Int>()
        for (i in dizi) {
            if (i % 2 == 0) {
                evenNumbers.add(i)
            }
        }
        return evenNumbers
    }

    // Listeyi tersine çevirme fonksiyonu

    fun tersListe(arrayList: ArrayList<Int>): ArrayList<Int> {
        val tersListe = ArrayList<Int>()

        for (i in arrayList.size - 1 downTo 0) {
            tersListe.add(arrayList[i])
        }

        return tersListe
    }

    // Tek sayıları bulan fonksiyon
    fun odd_numbers(baslangıc: Int, bitis: Int): MutableList<Int> {
        val tek_sayılar = mutableListOf<Int>()

        for (i in baslangıc..bitis) {
            if (i % 2 == 1) {
                tek_sayılar.add(i)
            }
        }
        return tek_sayılar
    }

    // Asal sayıları bulan fonksiyon

  fun prime_numbers ( sayı :Int): MutableList<Int>
  {
      val prime_number = mutableListOf<Int>()
      primeNumber@ for (n in 2..sayı) {
          for (d in 2 until n) {
              if (n % d == 0) continue@primeNumber

          }
          prime_number.add(n)
      }
      return  prime_number
  }




}