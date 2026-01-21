package com.example.trivialapp_base.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trivialapp_base.Routes

@Composable
fun EntryPoint(navigationController: NavController) {
    // Definim el component NavHost per a establir les rutes entre pantalles
    NavHost(
        navController = navigationController as NavHostController,
        startDestination = Routes.MenuScreen.route
    ) {
        composable(Routes.MenuScreen.route) { MenuScreen(navigationController) }

    }
}