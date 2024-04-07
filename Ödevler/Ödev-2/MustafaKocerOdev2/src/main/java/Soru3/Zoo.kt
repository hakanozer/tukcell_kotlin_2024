package Soru3

class Zoo(val animalList: MutableList<Animal>){


    fun yasamAlaninaGoreListele(istenilenYasamAlani : String) : MutableList<Animal>{
        val istenilenHayvanlar : MutableList<Animal> = mutableListOf()
        animalList.forEach { animal->
            if (animal.yasamAlani.equals(istenilenYasamAlani)){
                istenilenHayvanlar.add(animal)
            }
        }
        return istenilenHayvanlar
    }

}