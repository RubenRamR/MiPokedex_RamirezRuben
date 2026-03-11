package ramirez.ruben.composepokedex.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ramirez.ruben.composepokedex.Components.Ability
import ramirez.ruben.composepokedex.Components.Chip
import ramirez.ruben.composepokedex.Components.PokemonFooter
import ramirez.ruben.composepokedex.Components.PokemonHeader
import ramirez.ruben.composepokedex.R
import ramirez.ruben.composepokedex.domain.Pokemon
import ramirez.ruben.composepokedex.ui.theme.ComposePokedexTheme
import ramirez.ruben.composepokedex.ui.theme.electricYellow
import ramirez.ruben.composepokedex.ui.theme.offWhite

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    adjacentPokemons: Pair<Pokemon?, Pokemon?>,
    onNavigateDetail: (Int) -> Unit
) {
    Box(contentAlignment = Alignment.TopCenter) {
        Image(
            painter = painterResource(pokemon.image),
            contentDescription = pokemon.name,
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
                    pokemon.type,
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
                    Column {
                        Ability("row", label = "Altura", "${pokemon.height}m")
                        Ability("row", "Peso", "${pokemon.weight}kg")
                    }
                    Ability("column", label = "Habilidad", value = pokemon.ability)
                }

                Row(
                    Modifier
                        .fillMaxWidth(.8f)
                        .align(Alignment.CenterHorizontally)
                        .padding(25.dp)
                ) {
                    Text(pokemon.description)
                }

//-----
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp)
                ) {
                    if (pokemon.evolutions.isNotEmpty()) {
                        item {
                            Text(
                                text = "Evoluciones",
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                        items(pokemon.evolutions) { evolution ->
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = evolution.image),
                                    contentDescription = "Evolución a ${evolution.name}",
                                    modifier = Modifier.size(50.dp)
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Text(text = evolution.name)
                            }
                        }
                    }
                }

                PokemonFooter(
                    previousPokemon = adjacentPokemons.first,
                    nextPokemon = adjacentPokemons.second,
                    onNavigate = onNavigateDetail
                )
            }
        }
    }
}

@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    adjacentPokemons: Pair<Pokemon?, Pokemon?>,
    onNavigateDetail: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(electricYellow)
    ) {
        PokemonHeader(pokemon.name, pokemon.number, pokemon.fav)
        PokemonCard(pokemon, adjacentPokemons, onNavigateDetail)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposePokedexTheme {
        PokemonDetailScreen(
            pokemon = Pokemon(
                "Pikachu",
                25,
                "Electric",
                "Pokemon amarillo",
                0.4f,
                6f,
                true,
                "Estatíca",
                R.drawable.pikachu
            ),
            adjacentPokemons = Pair(null, null),
            onNavigateDetail = {}
        )
    }
}