package com.example.myfittrackapp.viewmodel

import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf


class HealthRecordViewModel {

    var height by mutableDoubleStateOf(0.0)
    var weight by mutableDoubleStateOf(0.0)
    var fatRate by mutableDoubleStateOf(0.0)
    var heartRate by mutableIntStateOf(0)
    var currentBMI by mutableFloatStateOf(0.0F)
    var perfectBMI by mutableFloatStateOf(0.0F)

    fun calculateBMI(){
        val h = height.toFloat()
        val w = weight.toFloat()
        if(h > 0 && w > 0){
            currentBMI = w / (h * h)
            perfectBMI = 22.0F
        }

    }


}