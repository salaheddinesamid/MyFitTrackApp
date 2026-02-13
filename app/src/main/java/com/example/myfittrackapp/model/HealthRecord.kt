package com.example.myfittrackapp.model

data class HealthRecord(
    val recordId : Long,
    val userId : Long,
    val height : Double,
    val weight : Double,
    val fatRate : Double,
    val heartRate : Int
)
