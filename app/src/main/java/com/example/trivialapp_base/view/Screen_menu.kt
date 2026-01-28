package com.example.trivialapp_base.view
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.trivialapp_base.R
import com.example.trivialapp_base.Routes
import com.example.trivialapp_base.viewmodel.GameViewModel


@Composable
fun MenuScreen(navController: NavController, viewModel: GameViewModel = viewModel(), modifier: Modifier = Modifier) {

    var selectedText: String by remember { mutableStateOf("") }
    var expanded: Boolean by remember { mutableStateOf(false) }
    val difficulty = listOf("Facil", "Medio","Dificil")


    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        val (logoRef, ddmRef,buttonRef) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo de la app",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(100.dp)
                .constrainAs(logoRef) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Column(
            Modifier
                .padding(20.dp, 80.dp)
                .constrainAs(ddmRef) {
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }

        ){
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
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Black, RoundedCornerShape(4.dp))
            ){
                difficulty.forEach { level ->
                    DropdownMenuItem(
                        text = { Text(text = level) },
                        onClick = {
                            expanded = false
                            selectedText = level
                        })
                }
            }
        }
        Button(
            onClick = {

                navController.navigate(Routes.GameScreen.route)
            },
            modifier = Modifier.constrainAs(buttonRef) {
                top.linkTo(ddmRef.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black
            ),
            border = BorderStroke(5.dp, Color.Gray)
        ) {
            Text("Play")
        }

    }
}