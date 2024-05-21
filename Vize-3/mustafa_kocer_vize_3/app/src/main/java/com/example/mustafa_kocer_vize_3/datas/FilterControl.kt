package com.example.mustafa_kocer_vize_3.datas

object FilterControl {
    private var isFiltered = false

        fun getIsFiltered(): Boolean{
            return isFiltered
        }

        fun setIsFiltered(filtered : Boolean){
           isFiltered = filtered
        }

    private var queryKey = ""

    fun getKeyName(): String{
        return queryKey
    }

    fun setKeyName(keyName : String){
        this.queryKey = keyName
    }

}