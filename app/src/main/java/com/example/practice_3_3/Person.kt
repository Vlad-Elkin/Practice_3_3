package com.example.practice_3_3

import android.util.Log
import org.json.JSONObject

class Person{
    var sex:Gender = Gender.UNKNOWN
    var name: String = ""
    var phoneNumber: String = ""

    constructor(json:JSONObject){
        when(json.getString("sex")){
            "MALE" -> this.sex = Gender.MALE
            "FEMALE" -> this.sex = Gender.FEMALE
            "UNKNOWN" -> this.sex = Gender.UNKNOWN
        }
        this.name = json.getString("name")
        this.phoneNumber = json.getString("phoneNumber")
    }

    override fun toString(): String {
        return "{" +
                "\"sex\":\"${sex.name}\"," +
                "\"name\":\"${name}\"," +
                "\"phoneNumber\":\"${phoneNumber}\"}"
    }
}
enum class Gender{
    MALE,FEMALE,UNKNOWN
}