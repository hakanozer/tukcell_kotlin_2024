class Using  {
    private val use = DB()

    fun call() {
        use.dbConnect()
    }
}

private class DB {

    private val dbName = "project.sqlite"
    private val dbVersion = 1


    fun dbConnect() {
        println("Connect Success : $dbName - $dbVersion")
    }


}