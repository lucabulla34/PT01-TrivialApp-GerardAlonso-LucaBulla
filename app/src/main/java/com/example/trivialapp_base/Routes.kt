package com.example.trivialapp_base

sealed class Routes(val route: String) {
    object MenuScreen : Routes("MenuScreen")
    object GameScreen : Routes("GameScreen")
}