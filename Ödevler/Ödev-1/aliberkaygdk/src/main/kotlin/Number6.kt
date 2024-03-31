fun main() {
    val primeList = primeNumbers(10)
    println(primeList)

}

//detaylı incelenmesi için bu şekilde bırakıyorum
fun primeNumbers(number: Int): List<Int> {

    val list = mutableListOf<Int>()
    val isComposite = BooleanArray(number + 1)

    isComposite.forEach { println(it) }

    //mantık şu şekilde işliyor
    //2 sayısının asal olduğunu biliyoruz. içteki döngü 2 nin katlarının asal sayı olamayacağını bildiğimizden diziyi işaretler yani 4,6,8,10 işaretli
    //3 için ise listeye eklendi . 3 ün katları işaretlendi
    //5 için 10 işaterlendi

    //bu algoritma adı eratothenes eleği olarak geçiyor
    for (index in 2..number) {
        if (!isComposite[index]) {
            list.add(index)

            for (multiple in index * 2..number step index) {
                isComposite[multiple] = true
            }
        }


    }
    println("------")
    isComposite.forEach { println(it) }

    return list
}



