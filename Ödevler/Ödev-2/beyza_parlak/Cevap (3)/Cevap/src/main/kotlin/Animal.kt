class Animal(val name: String, val type: String, val livingSpace: String) {
    // Hayvan bilgilerini görüntüleme fonksiyonu
    fun displayInfo() {
        println("Name: $name") // adı
        println("Species: $type") // türü
        println("Habitat: $livingSpace") // yaşam alanı
    }

}