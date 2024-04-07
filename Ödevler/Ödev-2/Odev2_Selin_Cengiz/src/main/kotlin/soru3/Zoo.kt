package soru3

open class Zoo {

    companion object {
        private var listAnimals = mutableListOf<Animal>()

        //Habitata göre filtreleme işlemi yapılmaktadır.
        fun filterByHabitat(habitat: String) = listAnimals.filter { it.habitat == habitat }

        //Zoo içerisindeki tüm hayvanları döndürür.
        fun getZooAnimals() = listAnimals
    }

    //Bu fonksiyon sayesinde listeye animal eklenmektedir.
    //Bu fonksiyon protected olarak oluşturulmuş olup sadece Animal sınıfında çağırılması amaçlanmıştır.
    //Animal sınıfından her nesne oluşturulduğunda fonksiyon tetiklenmektedir.
    protected fun addAnimal(animal: Animal) {
        listAnimals.add(animal)
    }


}