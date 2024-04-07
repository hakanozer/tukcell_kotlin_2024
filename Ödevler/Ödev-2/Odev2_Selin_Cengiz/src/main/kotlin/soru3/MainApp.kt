package soru3

fun main() {

    //Animal Class
    Animal("Seagull", "Bird", "Sea")
    Animal("Cape Lion", "Lion", "South Africa")

    //Zoo Class
    println("All zoo animals:")
    Zoo.getZooAnimals().forEach {
        println(it.name)
    } //Çıktı Seagull /n Cape Lion


    println("Filtered animals:")
    Zoo.filterByHabitat("Sea").forEach {
        println(it.name)
    }//Çıktı Seagull


}