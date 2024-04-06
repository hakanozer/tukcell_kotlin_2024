fun main() {

    //val st = "AHMET".call(2)
    //println(st)

    val action = Action()
    action.userName("AHMET")
    val status = action.login("ali01", "12345")
    println(status)

    val set1 = mutableSetOf<User>()
    val user1 = User()
    user1.setName("Alim")

    val user2 = User()
    user2.setName("Alim")

    set1.add(user1)
    set1.add(user2)
    println(set1)
    println(user1.hashCode())
    println(user2.hashCode())

    println("===================")
    val set2 = mutableSetOf<Customer>()
    val cus1 = Customer(100, "Mehmet", "Bilsin")
    println(cus1.hashCode())
    val cus2 = Customer(100, "Mehmet", "Bilsin")
    println(cus2.hashCode())
    cus2.cid = 101
    cus2.cid = 100

    set2.add(cus1)
    set2.add(cus2)
    println(set2)




}

