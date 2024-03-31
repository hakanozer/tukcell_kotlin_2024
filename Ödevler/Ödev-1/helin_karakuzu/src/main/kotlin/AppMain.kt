fun main(){

    fun soru1(){
        println("Lutfen bir dizi giriniz.Cikmak icin q'ya basiniz: ")
        var dizi = ArrayList<Int>()
        var ciftSayilar = ArrayList<Int>()

        while (true){
            var eleman = readLine()
            if (eleman == "q"){
                break
            }
            if (eleman!= null){
                dizi.add(eleman.toInt())
            }
        }

        for (i in dizi){
            if (i % 2 == 0){
                ciftSayilar.add(i)
            }
        }
        println(ciftSayilar)
    }

    fun soru2(){

    }

    fun soru3() {
        println("Lutfen bir dizi giriniz.Cikmak icin q'ya basiniz: ")
        var dizi = ArrayList<Int>()
        var tersListe = ArrayList<Int>()

        while (true){
            var eleman = readLine()
            if (eleman == "q"){
                break
            }
            if (eleman!= null){
                dizi.add(eleman.toInt())
            }
        }

        for(i in dizi.last() downTo dizi.first()){
            tersListe.add(i)
        }
        println(tersListe)
    }

    fun soru4(){
        var tekSayilar = ArrayList<Int>()
        println("Baslangic degeri giriniz : ")
        var baslangic = readLine()!!.toInt()
        println("Bitis degeri giriniz : ")
        var bitis = readLine()!!.toInt()

        for (i in baslangic..bitis){
            if(i % 2 != 0){
                tekSayilar.add(i)
            }
        }
        println(tekSayilar)

    }

    fun soru5(){
        println("Bir string giriniz: ")
        var str = readLine()!!
        var sesliHarfSayisi = 0

        for (char in str){
            if (char == 'a' || char == 'e' || char == 'i' || char == 'o' || char == 'u'  ) {
                sesliHarfSayisi++
            }
        }
        println(sesliHarfSayisi)
    }

    fun soru6(){
        println("Lütfen bir sayi siniri giriniz: ")
        val sinir = readLine()!!.toInt()
        val asalSayiList = ArrayList<Int>()

        for (i in 2..sinir) {
            var asal = true
            for (j in 2 until i) {
                if (i % j == 0) {
                    asal = false
                    break
                }
            }
            if (asal) {
                asalSayiList.add(i)
            }
        }
        println("Asal sayılar: $asalSayiList")
    }

    fun soru7() : Int{
        println("Bir text giriniz: ")
        val deger = readLine()!!
        var kelimeSayisi = 0

        if(deger != ""){
            for(char in deger){
                if(char == ' '){
                    kelimeSayisi++
                }
            }
            return (kelimeSayisi+1)
        } else {
            return kelimeSayisi
        }
    }

    fun soru8() {

    }

    fun soru9() {
        println("Birinci texti giriniz : ")
        var text1 = readLine()!!

        println("Ikinci texti giriniz : ")
        var text2 = readLine()!!

        if(text1.length == text2.length){
            println(text1.toUpperCase() + text2.toUpperCase())
        } else {
            println(text1+text2)
        }
    }

    fun soru10(){
        println("Lutfen bir liste giriniz.Cikmak icin q'ya basiniz: ")
        var dizi = ArrayList<Int>()

        while (true){
            var eleman = readLine()
            if (eleman == "q"){
                break
            }
            if (eleman!= null){
                dizi.add(eleman.toInt())
            }
        }

        println("Lutfen bir set giriniz.Cikmak icin q'ya basiniz: ")
        var set = HashSet<Int>()
        while (true){
            var eleman = readLine()
            if (eleman == "q"){
                break
            }
            if (eleman!= null){
                set.add(eleman.toInt())
            }
        }

        println(dizi.filterNot { it in set })
    }
}