abstract class Employee {

    abstract var tc: Long
    abstract fun accountNumber() : Int

    fun accountName() : String {
        val cid = accountNumber();
        var name = ""
        if (cid == 100) {
            name = "Ali Bilmem"
        }else if (cid == 200) {
            name = "Zehra Bilirim"
        }
        return name
    }

    fun accountTotal() : Int {
        val cid = accountNumber();
        var total = 0
        if (cid == 100) {
            total = 1000000
        }else if (cid == 200) {
            total = 2000000
        }
        return total
    }

}