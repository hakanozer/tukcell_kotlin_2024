fun main() {
    val zoo = Zoo()

    // add animals
    zoo.addAnimal(Animal("Kutup Ayısı", "Etçil", "Kutup"))
    zoo.addAnimal(Animal("Aslan", "Etçil", "Orman"))
    zoo.addAnimal(Animal("Ayı", "Etçil", "Orman"))
    zoo.addAnimal(Animal("Kaplan", "Etçil", "Orman"))
    zoo.addAnimal(Animal("Kartal", "Kuş", "Dağlık Alan"))

    // list animal by habitat
    zoo.listAnimalsByHabitat("Kutup")
}

