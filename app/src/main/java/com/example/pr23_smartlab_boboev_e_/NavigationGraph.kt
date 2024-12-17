package com.example.pr23_smartlab_boboev_e_

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pr23_smartlab_boboev_e_.screen.Analyzes
import com.example.pr23_smartlab_boboev_e_.screen.MainScreen
import com.example.pr23_smartlab_boboev_e_.screen.OnboardingScreen
import com.example.pr23_smartlab_boboev_e_.screen.Patient_Record
import com.example.pr23_smartlab_boboev_e_.screen.Registration
import com.example.pr23_smartlab_boboev_e_.screen.Splash
import com.example.pr23_smartlab_boboev_e_.screen.password
import com.example.pr23_smartlab_boboev_e_.screen.screenw

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            Splash(navController = navController)
        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.Registration.route) {
            Registration(navController = navController)
        }
        composable(route = Screen.password.route) {
            password(navController = navController)
        }
        composable(route = Screen.Patient_Record.route) {
            Patient_Record(navController = navController)
        }
        composable(route = Screen.Analyzes.route) {
            Analyzes(navController = navController)
        }
        composable(route = Screen.screenw.route) {
            screenw(navController = navController)
        }

    }
}