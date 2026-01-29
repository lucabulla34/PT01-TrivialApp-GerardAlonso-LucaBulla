package com.example.trivialapp_base.view

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel
@Composable
fun RespuestaButton(
    texto: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = texto)
    }
}
@Composable
fun GameScreen(navController: NavController, viewModel: GameViewModel) {

    LaunchedEffect(Unit) {
        viewModel.iniciarJuego()
    }

    if (viewModel.juegoTerminado) {
        LaunchedEffect(Unit) {
            navController.navigate(Routes.ResultScreen.route)
        }
        return
    }

    val pregunta = viewModel.preguntaActual ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            LinearProgressIndicator(
                progress = { viewModel.tiempoRestante },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
            )

            val segundosRestantes = (viewModel.tiempoRestante * 10).toInt()
            Text(
                text = "Tiempo restante: $segundosRestantes s",
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )

            Text(
                text = pregunta.pregunta,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 24.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                viewModel.respuestasMezcladas.forEach { respuesta ->
                    RespuestaButton(respuesta) {
                        viewModel.responderPregunta(respuesta)
                    }
                }
            }
        }

    }
}


