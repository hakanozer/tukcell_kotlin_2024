fun <T> tersCevir(liste: List<T>): List<T> {
    val tersListe = mutableListOf<T>()
    for (i in liste.indices.reversed()) {
        tersListe.add(liste[i])
    }
    return tersListe
}

fun main() {
    val asilListe = listOf(1, 2, 3, 4, 5)
    val tersListe = tersCevir(asilListe)
    println("Asıl Liste: $asilListe")
    println("Ters Liste: $tersListe")
}