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
import ramirez.ruben.composepokedex.ui.theme.ComposePokedexTheme
import ramirez.ruben.composepokedex.ui.theme.electricYellow
import ramirez.ruben.composepokedex.ui.theme.offWhite

class MainActivity : ComponentActivity() {

    val pokemon = Pokemon(
        "Pikachu",
        25,
        "Electric",
        "sisisisii",
        0.4f,
        6f,
        true,
        "nonoononon",
        R.drawable.pikachu
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePokedexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        pokemon,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PokemonCard(
    name: String,
    weight: Float,
    height: Float,
    description: String,
    ability: String,
    image: Int,
    type: String
) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(image),
            contentDescription = name,
            Modifier
                .offset(0.dp, -80.dp)
                .zIndex(2f)
                .size(130.dp),
            contentScale = ContentScale.Fit
        )
        Card(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = offWhite)
        ) {
            Column(Modifier.fillMaxWidth()) {
                Chip(
                    type,
                    electricYellow,
                    Modifier
                        .padding(top = 70.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(top = 5.dp), horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Column() {
                        Ability("row", label = "Altura", "${height}m")
                        Ability("row", "Peso", "${weight}kg")
                    }
                    Ability("column", label = "Habilidad", value = ability)
                }

                Row(
                    Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(25.dp)
                ) {
                    Text(description)
                }
                Spacer(modifier = Modifier.weight(1f))

                PokemonFooter()
            }

        }
    }
}

@Composable
fun PokemonHeader(name: String, number: Int, fav: Boolean) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(name)
            Text("#${number}", modifier = Modifier.align(Alignment.End))
        }
        Box {
            Image(
                painter = painterResource(R.drawable.pokeball),
                contentDescription = "pokeball image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(130.dp)
                    .offset(30.dp, 20.dp)
            )

            Image(
                painter = painterResource(if (fav) R.drawable.star_filled else R.drawable.star_outline),
                contentDescription = if (fav) "yellow star filled" else "yellow star outline",
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHeaderPreview() {
    ComposePokedexTheme() {
        PokemonHeader("Pikachu", 25, true)
    }
}

@Composable
fun Greeting(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(electricYellow)
    ) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(
            pokemon.name,
            pokemon.weight,
            pokemon.height,
            pokemon.description,
            pokemon.ability,
            pokemon.image,
            pokemon.type
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePokedexTheme {
        Greeting(
            Pokemon(
                "Pikachu",
                25,
                "Electric",
                "Pokemon amarillo",
                0.4f,
                6f,
                true,
                "Estatíca",
                R.drawable.pikachu
            )
        )
    }
}