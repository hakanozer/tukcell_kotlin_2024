package assignment_three

class Animals : Zoo(){


    fun getLiveAreaLiveAnimals(liveArea:String) : List<Animal>{

        // miras alınan sınıftaki animallist'e super keywordüyle eriştik
        val resultList = super.animalList.filter {animal->
            animal.animalLivingArea == liveArea
        }

        return resultList
    }




}