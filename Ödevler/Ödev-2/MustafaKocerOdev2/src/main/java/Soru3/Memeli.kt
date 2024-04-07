package Soru3

class Memeli: Animal {

      constructor(name: String, tur: String, yasamAlani: String): super(name, tur, yasamAlani){

    }

    override fun sesCikar() : String{
        return "moo moo moo"
    }
}