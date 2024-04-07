package Soru3

fun main(){

    val animal1 = Memeli("Aslan", "Memeli", "Kara")
    val animal2 = Surungen("Kaplumbağa", "Sürüngen", "Kara")
    val animal3 = Memeli("Köpek", "Memeli", "Kara")
    val animal4 = Kus("Kartal", "Kuş", "Hava")
    val animal5 = Memeli("Balina", "Memeli", "Su")
    val animal6 = Surungen("Kara Yılanı", "Sürüngen", "Kara")
    val animal7 = Memeli("Kedi", "Memeli", "Kara")
    val animal8 = Surungen("Timsah", "Sürüngen", "Su")
    val animal9 = Kus("Baykuş", "Kuş", "Hava")
    val animal10 = Memeli("Fare", "Memeli", "Kara")

    val animals : MutableList<Animal> = mutableListOf(animal1, animal2, animal3, animal4, animal5, animal6, animal7, animal8, animal9, animal10)

    val zoo = Zoo(animals)

    val istenilenListe =     zoo.yasamAlaninaGoreListele("Hava")

    istenilenListe.forEach { hayvan->
        println("Hayvanın ismi: ${hayvan.name}, türü: ${hayvan.tur}, yasam alani: ${hayvan.yasamAlani}")
    }
    println("\n\n")

    animals.forEach { hayvan ->
        print("Hayvanın ismi: ${hayvan.name}, türü: ${hayvan.tur}, yasam alani: ${hayvan.yasamAlani}, Ses cikarma : ")

        sesCikar(hayvan)
    }



}

fun sesCikar( hayvan: Animal){

            if (hayvan is Kus)
                println("Ben kusum, ucabilirim ${hayvan.sesCikar()}")
            if (hayvan is Memeli)
                println("Ben memeliyim, yavrumu sütle beslerim ${hayvan.sesCikar()}")
            if (hayvan is Surungen)
                println("Ben surungenim, surune surune giderim ${hayvan.sesCikar()}")

    }