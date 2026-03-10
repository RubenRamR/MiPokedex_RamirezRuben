package ramirez.ruben.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import ramirez.ruben.composepokedex.Components.PokemonFooter
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ramirez.ruben.composepokedex.Components.Ability
import ramirez.ruben.composepokedex.Components.Chip
import ramirez.ruben.composepokedex.domain.Pokemon
import ramirez.ruben.composepokedex.navigation.MyApp
import ramirez.ruben.composepokedex.screens.PokemonDetailScreen
import ramirez.ruben.composepokedex.ui.theme.ComposePokedexTheme
import ramirez.ruben.composepokedex.ui.theme.electricYellow
import ramirez.ruben.composepokedex.ui.theme.offWhite

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon(
        "Pikachu",
        25,
        "Electric",
        "Pikachu, el Pokémon Ratón (tipo eléctrico#025), es conocido por almacenar electricidad en sus mejillas rojas, lanzando descargas cuando se enfada o se siente amenazado. Es amarillo con rayas marrones en la espalda, orejas largas con puntas negras y una cola en forma de rayo.",
        0.4f,
        6f,
        true,
        "Electricidad Estática",
        R.drawable.pikachu
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposePokedexTheme {
                MyApp()
            }
        }
    }
}