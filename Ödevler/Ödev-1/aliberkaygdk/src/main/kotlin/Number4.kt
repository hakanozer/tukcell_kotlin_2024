fun main() {
    oddNumberFinder(80, 70)
}


fun oddNumberFinder(number1: Int, number2: Int) {
    val oddNumbers = mutableListOf<Int>()

    //parametreler default olarak sabit oluyor. bu yüzden yeni değişkenler oluşturdum
    var num1 = number1
    var num2 = number2

    if (num1 > num2) {
        //transporter = veri değişiminde geçici bellek görevi
        //amaç num1 ve num2 yi yer değiştirmek
        //bu sayede kullanıcı ilk veriyi 2. den daha büyük değer verse bile aralığı yine ekrana getirecektir
        var transporter = 0
        transporter = num2
        num2 = num1
        num1 = transporter
    }

    for (number in num1..num2) {
        if (number % 2 == 1) {
            oddNumbers.add(number)
        }

    }
    println(oddNumbers)

}