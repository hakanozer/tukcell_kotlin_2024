
/*
Belirli bir sayıya kadar olan asal sayıları içeren bir listeyi oluşturan bir fonksiyon
yazın.
*/

fun main() {

    val number = 30

    val result = getPrimeNumbers(number)

    println(result)
}

fun getPrimeNumbers(number:Int): MutableSet<Int>{
    val primeNumbers = mutableSetOf<Int>()

    // en küçük asal sayı olan 2DEn başladık sayının bi fazlasına  kadar döndürdük
    for (num in 2 until number+1){
        var isPrime = true
        // her sayının kendinden kücük olan sayılarını tekrar döndürdük
        for (subnum in 2 until num){

            // eğer sayı bu kendinden küçük  sayılara bölünüyorsa asal değildir break ile bloğu kırdık ve gereksiz çalışmadan kurtardık
            if (num % subnum == 0){
                isPrime = false
                break
            }
        }
        if (isPrime){
            primeNumbers.add(num)
        }
    }
    return  primeNumbers
}

