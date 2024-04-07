package question_5

class Computer : Product {

    var brand = ""

    constructor( id: Int,  name: String,  price: Double, brand: String) : super(id, name, price){
        this.brand = brand
    }


}