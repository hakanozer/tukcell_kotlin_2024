class VipCustomer( name: String, email: String, phoneNumber: String, var vipLevel: Int)
    :Customer( name, email, phoneNumber
){





        fun increaseVipLevel(){
            vipLevel++
        }


    fun decreaseVipLevel(){
        vipLevel--
    }

    override fun toString(): String {
        return super.toString()+"\nVip Level: $vipLevel"
    }
}