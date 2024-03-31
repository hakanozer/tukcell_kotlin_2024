fun main() {
    val x = concat("ali","ece")
    println(x)


}
fun concat(string1: String,string2: String):String{
    var conc = ""

    if (string1.length == string2.length){

        conc = string1.plus(string2).uppercase()

    }else{

        conc = string1.plus(string2)

    }



    return conc
}