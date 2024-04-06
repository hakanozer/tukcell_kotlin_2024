class User {

    private var name:String = ""
    //private var surname:String = ""

    fun getName() : String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    override fun toString(): String {
        return "User(name='$name')"
    }


}