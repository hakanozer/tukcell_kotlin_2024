package org.example.Task3

class Zoo {

    val animalsOnZoo:MutableList<Animal> = mutableListOf() // Hayvanat bahçesindeki hayvanlar için Animal türünde bir  liste oluşturulmuştur

    fun addAnimals(animal:Animal){ // Yeni bir hayvan eklemek
        animalsOnZoo.add(animal)
    }

    fun isThereHabitat():MutableMap<String,String>{ // Hayvanların eğer belirli bir habitatı varsa, bu hayvanların map'ini döndürür(hayvanın ismi ve habitatı şeklinde)
        val animalsHabitat= mutableMapOf<String,String>()
        animalsOnZoo.forEach {
            if(it.habitat!=null && it.habitat!="" &&it.habitat!=" "){
                animalsHabitat.put(it.name,it.habitat)
            }
        }

        return animalsHabitat
    }




}