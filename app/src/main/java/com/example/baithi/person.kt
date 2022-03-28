package com.example.baithi
import java.util.*
data class person( var id : Int = getAutoId() ,var name : String , var phone : String , var address : String){
    companion object{

        fun getAutoId ():Int{
            val random = Random()
            return random.nextInt(100)
        }

    }

}