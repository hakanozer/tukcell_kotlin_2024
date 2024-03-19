import java.util.ArrayList

fun main() {

    // listOf
    // immutable
    val xarr = listOf<String>("Ankara", "İstanbul", "İzmir")

    // mutable
    val arr = mutableListOf<String>()
    val arr1 = ArrayList<String>()

    // add item
    arr.add("Ankara")
    arr.add("İstanbul")
    arr.add("İstanbul")
    arr.add("İstanbul")
    arr.add("İzmir")
    arr.add(1, "Bursa")

    //arr.remove("Ankarax")
    //arr.removeAt(0)
    //arr.clear()
    //arr.removeAll(listOf("İstanbul"))

    val indexOf = arr.indexOf("Ankarax")
    if (indexOf > -1) {
        arr.removeAt(indexOf)
        println("Delete Success")
    }

    arr.set(2, "Antalya")

    val datas = mutableListOf<String>()
    for (i in 0..9) {
        datas.add("Title -  $i")
    }

    println("=================")
    val start = System.currentTimeMillis()

    datas.onEach {
        try {
            Thread.sleep(1)
        }catch (err: Error) {}
        println(it)
    }
    val end = System.currentTimeMillis()
    val between = end - start
    println("between: $between")

    val status1 = arr.contains("İstanbul")
    println(status1)
    if ( "İstanbul" in arr ) {

    }

    arr.isEmpty()
    arr.size
    println("=================")
    for (i in 0..<arr.size) {
        println(arr.get(i))
    }

    // slice
    val newArr = arr.slice(0..2)
    println("newArr: $newArr")

    // filter
    val filterArr = arr.filter {
        it.count() > 6 && it.contains("b")
    }
    println(filterArr)

    val theList = listOf(10, 12, 30, 31, 40, 9, -3, 0)
    val mapResult = theList.groupBy{ it % 3}
    println(mapResult.get(0))
    println(mapResult.get(1))

    val mapx =  arr.groupBy { it.contains("z")  }
    println(mapx.get(true))
    println(mapx.get(false))

    val arrx = arr.map { "$it-TR".trim() }
    println(arrx)



    println(arr)
    //println(xarr)
}