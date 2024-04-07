

fun main() {
    // Hayvanat bahçesi oluşturma
    val zoo = Zoo()

    // Hayvanlar oluşturma
    val Kaplan = Animal("Bengal Kaplanı", "Kedigiller", "Hindistan")
    val Vaşak = Animal("İber Vaşak", "Kedigiller", "Portekiz")
    val At = Animal("Frizyen atı", "At", "Hollanda")


    // Hayvanları hayvanat bahçesine ekle
    zoo.addAnimal(Kaplan)
    zoo.addAnimal(Vaşak)
    zoo.addAnimal(At)


    // Belirli bir yaşam alanına sahip hayvanları listeleme
    zoo.listAnimalsInHabitat("Portekiz")
}