package com.example.myfittrackapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import com.example.myfittrackapp.model.Gender

/**
 *
 */
class RegisterViewModel {

    var firstName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var confirmPassword by mutableStateOf("")
    var gender by mutableStateOf("")
    var age by mutableIntStateOf(0)
    var height by mutableDoubleStateOf(0.0)
    var weight by mutableDoubleStateOf(0.0)

    var bodyFat by mutableDoubleStateOf(0.0)

    private val successMessage : String = ""
    private val errorMessage : String = ""
    private val bodyFatStatus : String = "" // Good, Overweight, Obese


    // calculate the body fat based on the height and weight
    fun calculateBodyFat (){
        val h = height.toFloat()
        val w = weight.toFloat()
        val a = age.toFloat()
        if(h > 0 && w > 0 && a > 0){
            val bmi = w / (h * h)
            // Calculate the body fat based on the gender
            bodyFat = if (gender == Gender.FEMALE.toString()){
                1.20 * bmi + 0.23 * a - 5.4
            } else {
                1.20 * bmi + 0.23 * a - 10.8
            }
        }

    }

}