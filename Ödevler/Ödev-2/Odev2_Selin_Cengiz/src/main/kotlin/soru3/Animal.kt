package soru3

class Animal(val name: String, val type: String, val habitat: String) : Zoo() {

    //init fonksiyonu ile nesne oluşturulduğunda super class içerisindeki addAnimal fonksiyonu çağrılır.
    //Böylece nesne oluşturulduğunda animal zoo'ya eklenmiş olur.
    init {
        super.addAnimal(this)
    }

    //Any sınıfındaki toString metodu override edilerek sınıfın String olarak çıktısı verilmiştir.
    override fun toString(): String {
        return "Name:$name, Type:$type, Habitat:$habitat"
    }


}