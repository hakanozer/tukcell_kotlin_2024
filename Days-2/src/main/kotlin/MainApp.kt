import java.util.Random

fun main() {

    val num1 = 10.0
    val num2 = 15.0
    var end = 0.0

    // toplama
    end = num1 + num2
    println("Toplam: $end")

    // çıkarma
    end = num1 - num2
    println("Çıkarma: $end")

    // bölme
    end = num1 / num2
    var st = end.toString()
    st = st.substring(0, 4)
    println("Bölme: $st")

    // Çarpma
    end = num1 * num2
    println("Bölme: ${end}")

    // Mod
    end = num2 % num1
    println("Mod: ${end}")

    // Kıyaslama operatörleri
    var status = false

    // büyükse
    status = num1 > num2
    println("büyükse: $status")

    // küçükse
    status = num1 < num2
    println("küçükse: $status")

    // büyük veya eşitse
    status = num1 >= num2
    println("büyük veya eşitse: $status")

    // küçük veya eşitse
    status = num1 <= num2
    println("küçük veya eşitse: $status")

    // eşit ise
    status = num1 == num2
    println("eşit ise: $status")

    // eşit değilse
    status = num1 != num2
    println("eşit değilse: $status")


    val v1:Any = num1
    val v2:Any = num2
    println("v1 Hashcode: ${v1.hashCode()}")
    println("v2 Hashcode: ${v2.hashCode()}")
    status = v1 === v2
    println("Any Kıyaslama: $status")

    // atama ve işlem yapma
    var n1 = 11
    var n2 = 12

    // +=
    n1 += n2 // n1 = n1 + n2
    println("+= $n1")

    // -=
    n1 -= n2
    println("-= $n1")

    // *=
    n1 *= n2
    println("*= $n1")

    // *=
    n1 /= n2
    println("/= $n1")

    // %=
    n1 %= n2
    println("+= $n1")

    println("n1: $n1")
    println("n2: $n2")

    // Artırma ve eksiltme
    // ++
    ++n1 // n1 = n1 + 1
    n1++
    println(n1++)
    println(n1)

    if (++n1 > 14) {
        println("14 ten büyüktür")
    }else {
        println("14 ten küçüktür")
        println(n1)
    }

    if (!(n1 > 14)) {
       println("koşul doğru")
    }else {
        println("koşul sağlanmıyor")
    }

    // logic operatörler
    val a = 10
    val b = 20
    val c = 30

    // && -> ve
    // soldaki koşul ile sağdaki koşulun sağlanması
    status = b > 25 && c > 25
    println("&&: $status")

    val obj:Random? = null
    if ( obj != null && obj.nextInt(100) > 50 ) { }

    // || -> veya
    status = a > 15 || b > c || c > 25
    println("||: $status")

    // iç içe kullanım
    status = (a > fncA() || c > fncC()) && b > fncB()
    println("İçe içe: $status")

}

fun fncA(): Int {
    println("fncA")
    return 5
}
fun fncC(): Int {
    println("fncC")
    return 40
}
fun fncB(): Int {
    println("fncB")
    return 25
}