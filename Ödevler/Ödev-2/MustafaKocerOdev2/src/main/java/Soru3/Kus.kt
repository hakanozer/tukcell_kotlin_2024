package Soru3

class Kus : Animal {


    constructor(name: String, tur: String, yasamAlani: String): super(name, tur, yasamAlani){

    }

    override fun sesCikar(): String {

      return "cik cik cik"
    }


}