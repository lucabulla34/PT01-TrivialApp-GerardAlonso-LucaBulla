package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {
    private var preguntasPartida: List<Pregunta> = emptyList()
    var indicePreguntaActual by mutableIntStateOf(0)
        private set

    var preguntaActual by mutableStateOf<Pregunta?>(null)
        private set

    var respuestasMezcladas by mutableStateOf<List<String>>(emptyList())
        private set

    var puntuacion by mutableIntStateOf(0)
        private set

    var tiempoRestante by mutableFloatStateOf(1f)
        private set

    var juegoTerminado by mutableStateOf(false)
        private set

    var dificultadSeleccionada by mutableStateOf("Facil")
        private set

    private var timer: CountDownTimer? = null

    private var juegoIniciado = false
    private val TIEMPO_POR_PREGUNTA = 10000L // 10 segons

    fun setDificultad(dificultad: String) {
        dificultadSeleccionada = dificultad
    }

    fun iniciarJuego() {
        if (juegoIniciado) return
        juegoIniciado = true

        preguntasPartida = ProveedorPreguntas.obtenerPreguntas()
            .filter { it.dificultad == dificultadSeleccionada }

        indicePreguntaActual = 0
        puntuacion = 0
        juegoTerminado = false

        cargarSiguientePregunta()
    }

    private fun cargarSiguientePregunta() {
        if (indicePreguntaActual >= preguntasPartida.size) {
            juegoTerminado = true
            return
        }

        preguntaActual = preguntasPartida[indicePreguntaActual]
        respuestasMezcladas = listOf(
            preguntaActual!!.respuesta1,
            preguntaActual!!.respuesta2,
            preguntaActual!!.respuesta3,
            preguntaActual!!.respuesta4
        ).shuffled()

        iniciarTimer()
    }

    fun responderPregunta(respuestaUsuario: String) {
        timer?.cancel()

        if (respuestaUsuario == preguntaActual?.respuestaCorrecta) {
            puntuacion++
        }

        avanzarRonda()
    }

    private fun avanzarRonda() {
        indicePreguntaActual++
        cargarSiguientePregunta()
    }

    private fun iniciarTimer() {
        timer?.cancel()

        tiempoRestante = 1f

        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 100) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante =
                    millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA
            }

            override fun onFinish() {
                tiempoRestante = 0f
                avanzarRonda()
            }
        }.start()
    }


    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
    fun resetGame() {
        puntuacion = 0
        indicePreguntaActual = 0
        preguntaActual = null
        juegoTerminado = false
        tiempoRestante = 1f
        juegoIniciado = false
        iniciarJuego()
    }
}





