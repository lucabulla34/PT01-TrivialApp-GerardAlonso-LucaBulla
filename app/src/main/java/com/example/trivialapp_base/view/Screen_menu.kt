package com.example.trivialapp_base.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.trivialapp_base.viewmodel.GameViewModel
import com.example.trivialapp_base.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel = viewModel()) {
    val scrollState = rememberScrollState()

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 56.dp)
            .verticalScroll(scrollState)
    ) {
        val (logoRef) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la app",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .constrainAs(logoRef) {
                    top.linkTo(parent.top, margin = 20.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        
}
    @Composable
    fun MyDropDownMenu() {
        var selectedText by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val difficulty = listOf("Facil", "Normal", "Dificil")

        Column(Modifier.padding(20.dp)) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable { expanded = true }
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                difficulty.forEach { level ->
                    DropdownMenuItem(text = { Text(text = level) },
                        onClick = {
                            expanded = false
                            selectedText = level
                        })
                }
            }

        }


    }

}