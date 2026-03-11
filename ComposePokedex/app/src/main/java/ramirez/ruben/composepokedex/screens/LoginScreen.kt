package ramirez.ruben.composepokedex.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onNavigateToMenu: () -> Unit, onNavigateToRegister: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Pantalla de Login")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onNavigateToMenu) {
            Text("Entrar al Pokedex")
        }
        Button(onClick = onNavigateToRegister) {
            Text("Ir a Registro")
        }
    }
}