package com.example.trivialapp_base

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.trivialapp_base.ui.theme.TrivialAPP_BaseTheme
import androidx.compose.material3.MaterialTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trivialapp_base.view.GameScreen
import com.example.trivialapp_base.view.MenuScreen
import com.example.trivialapp_base.view.ResultScreen
import com.example.trivialapp_base.viewmodel.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            TrivialAPP_BaseTheme {
                val navController = rememberNavController()
                val gameViewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

                NavHost(
                    navController = navController,
                    startDestination = Routes.MenuScreen.route
                ) {
                    composable(Routes.MenuScreen.route) {
                        MenuScreen(navController, gameViewModel)
                    }
                    composable(Routes.GameScreen.route) {
                        GameScreen(navController, gameViewModel)
                    }
                    composable(Routes.ResultScreen.route) {
                        ResultScreen(navController, gameViewModel)
                    }
                }
            }
        }


                // Instanciamos el ViewModel una vez



                // Definición de rutas y navegación



    }
}

