package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel

@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel = viewModel()) {

    var expanded by remember { mutableStateOf(false) }

    val opcionesDisponibles = viewModel.obtenerOpcionesDisponibles()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (logoRef, typeButtonsRef, dropdownRef, playButtonRef) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la app",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(150.dp)
                .constrainAs(logoRef) {
                    top.linkTo(parent.top, margin = 60.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.constrainAs(typeButtonsRef) {
                top.linkTo(logoRef.bottom, margin = 32.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Button(
                onClick = { viewModel.setTipoFiltroUsuario("DIFICULTAD") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (viewModel.tipoFiltro == "DIFICULTAD") MaterialTheme.colorScheme.primary else Color.Gray
                )
            ) { Text("Dificultad") }

            Button(
                onClick = { viewModel.setTipoFiltroUsuario("CATEGORIA") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (viewModel.tipoFiltro == "CATEGORIA") MaterialTheme.colorScheme.primary else Color.Gray
                )
            ) { Text("Categoría") }
        }

        if (viewModel.tipoFiltro != null) {
            Column(
                Modifier
                    .padding(horizontal = 40.dp)
                    .constrainAs(dropdownRef) {
                        top.linkTo(typeButtonsRef.bottom, margin = 24.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {
                Text(
                    text = "Selecciona ${viewModel.tipoFiltro?.lowercase()}:",
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Box {
                    OutlinedTextField(
                        value = viewModel.valorFiltroSeleccionado ?: "",
                        onValueChange = { },
                        enabled = false,
                        readOnly = true,
                        placeholder = { Text("Selecciona una opción") },
                        modifier = Modifier
                            .clickable { expanded = true }
                            .fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            disabledTextColor = Color.Black,
                            disabledBorderColor = MaterialTheme.colorScheme.primary,
                            disabledPlaceholderColor = Color.Gray
                        )
                    )
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .clickable { expanded = true }
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .background(Color.White)
                        .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                ) {
                    opcionesDisponibles.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(text = opcion) },
                            onClick = {
                                expanded = false
                                viewModel.setValorFiltroUsuario(opcion)
                            }
                        )
                    }
                }
            }
        }

        if (viewModel.valorFiltroSeleccionado != null) {
            Button(
                onClick = {
                    viewModel.resetGame()
                    navController.navigate(Routes.GameScreen.route)
                },
                modifier = Modifier
                    .padding(top = 20.dp)
                    .constrainAs(playButtonRef) {
                        top.linkTo(dropdownRef.bottom, margin = 20.dp)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                    .fillMaxWidth(0.5f)
                    .height(50.dp)
            ) {
                Text("JUGAR", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}