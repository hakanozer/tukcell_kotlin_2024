interface IUser {

    fun userLogin( userName: String, password: String ) : Boolean
    fun userName( userID: Int ) : String
    fun userLogout( userID: Int ) : Boolean

}