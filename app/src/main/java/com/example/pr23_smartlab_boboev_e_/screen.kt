package com.example.pr23_smartlab_boboev_e_

sealed class Screen(val route: String) {
    object Splash : Screen("Splash")
    object Onboarding : Screen("Onboarding")
    object MainScreen : Screen("MainScreen")
    object Registration : Screen("Registration")
    object Patient_Record : Screen("Patient_Record")
    object password : Screen("Password")
    object Analyzes : Screen("Analyzes")
    object screenw : Screen("screenw")
}