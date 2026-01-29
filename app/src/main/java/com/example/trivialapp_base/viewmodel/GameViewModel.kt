package com.example.trivialapp_base.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.trivialapp_base.model.Pregunta
import com.example.trivialapp_base.model.ProveedorPreguntas

class GameViewModel : ViewModel() {

    var tipoFiltro by mutableStateOf<String?>(null) // "DIFICULTAD" o "CATEGORIA"
        private set

    var valorFiltroSeleccionado by mutableStateOf<String?>(null) // "Facil", "Ciencia", etc.
        private set

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

    private var timer: CountDownTimer? = null
    private val TIEMPO_POR_PREGUNTA = 10000L


    fun setTipoFiltroUsuario(tipo: String) {
        tipoFiltro = tipo
        valorFiltroSeleccionado = null
    }

    fun setValorFiltroUsuario(valor: String) {
        valorFiltroSeleccionado = valor
    }

    fun obtenerOpcionesDisponibles(): List<String> {
        val todas = ProveedorPreguntas.obtenerPreguntas()
        return when (tipoFiltro) {
            "DIFICULTAD" -> listOf("Facil", "Medio", "Dificil")
            "CATEGORIA" -> todas.map { it.categoria }.distinct().sorted()
            else -> emptyList()
        }
    }


    fun iniciarJuego() {
        val todas = ProveedorPreguntas.obtenerPreguntas()

        val preguntasFiltradas = if (tipoFiltro == "DIFICULTAD") {
            todas.filter { it.dificultad == valorFiltroSeleccionado }
        } else {
            todas.filter { it.categoria == valorFiltroSeleccionado }
        }

        preguntasPartida = preguntasFiltradas.shuffled().take(10)
        // Métodos shuffled y take sugeridos por la IA Gemini.

        if (preguntasPartida.isEmpty()) return

        indicePreguntaActual = 0
        puntuacion = 0
        juegoTerminado = false
        tiempoRestante = 1f

        cargarSiguientePregunta()
    }

    private fun cargarSiguientePregunta() {
        if (indicePreguntaActual >= preguntasPartida.size) {
            juegoTerminado = true
            timer?.cancel()
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
        indicePreguntaActual++
        cargarSiguientePregunta()
    }

    private fun iniciarTimer() {
        timer?.cancel()
        tiempoRestante = 1f
        timer = object : CountDownTimer(TIEMPO_POR_PREGUNTA, 100) {
            override fun onTick(millisUntilFinished: Long) {
                tiempoRestante = millisUntilFinished.toFloat() / TIEMPO_POR_PREGUNTA
            }
            override fun onFinish() {
                tiempoRestante = 0f
                indicePreguntaActual++
                cargarSiguientePregunta()
            }
        }.start()
    }

    fun resetGame() {
        puntuacion = 0
        indicePreguntaActual = 0
        preguntaActual = null
        juegoTerminado = false
        timer?.cancel()
    }

    fun setDificultad(dificultad: String) {
        tipoFiltro = "DIFICULTAD"
        valorFiltroSeleccionado = dificultad
    }
}