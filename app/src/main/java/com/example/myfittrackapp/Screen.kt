package com.example.myfittrackapp

/**
 *
 */
sealed class Screen (val route : String){
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object HealthRecord : Screen("health_record")
    object DietPlan : Screen("diet_plan")
    object ExercisePlan : Screen("exercise_plan")
    object Profile : Screen("profile")
}