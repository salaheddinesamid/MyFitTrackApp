package com.example.myfittrackapp.model

data class User(
    val userId : Long,
    var firstName : String,
    var lastName : String,
    var email : String,
    var password : String,
    var gender : String,
    var age : Int,
    var height : Double,
    var weight : Double,
    var bodyFat : Double,
    var heartRate : Int
)


enum class Gender{
    MALE,
    FEMALE
}
