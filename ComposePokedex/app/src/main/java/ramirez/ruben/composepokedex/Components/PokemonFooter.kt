package ramirez.ruben.composepokedex.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ramirez.ruben.composepokedex.R
import ramirez.ruben.composepokedex.domain.Pokemon

@Composable
fun PokemonNavItem(
    isPrevious: Boolean,
    pokemon: Pokemon, 
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = "Imagen de ${pokemon.name}",
            modifier = Modifier.size(70.dp)
        )
        val formattedNumber = pokemon.number.toString().padStart(4, '0')
        val textValue = "${pokemon.name} N.º $formattedNumber"

        if (isPrevious) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(24.dp).background(Color.DarkGray, CircleShape), contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.KeyboardArrowLeft, contentDescription = null, tint = Color.White)
                }
                Spacer(modifier = Modifier.width(6.dp))
                Text(text = textValue, color = Color.DarkGray, fontSize = 12.sp)
            }
        } else {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = textValue, color = Color.DarkGray, fontSize = 12.sp)
                Spacer(modifier = Modifier.width(6.dp))

                Box(modifier = Modifier.size(24.dp).background(Color.DarkGray, CircleShape), contentAlignment = Alignment.Center) {
                    Icon(Icons.Default.KeyboardArrowRight, contentDescription = null, tint = Color.White)
                }
            }
        }
    }
}

@Composable
fun PokemonFooter(
    previousPokemon: Pokemon?,
    nextPokemon: Pokemon?,
    onNavigate: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterStart) {
            if (previousPokemon != null) {
                PokemonNavItem(
                    isPrevious = true,
                    pokemon = previousPokemon,
                    onClick = { onNavigate(previousPokemon.number) }
                )
            }
        }

        Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.CenterEnd) {
            if (nextPokemon != null) {
                PokemonNavItem(
                    isPrevious = false,
                    pokemon = nextPokemon,
                    onClick = { onNavigate(nextPokemon.number) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FooterPreview() {
    val dummyArbok = Pokemon("Arbok", 24, "Poison", "Serpiente", 3.5f, 65f, false, "Intimidación", R.drawable.arbok)
    val dummyRaichu = Pokemon("Raichu", 26, "Electric", "Ratón eléctrico", 0.8f, 30f, false, "Electricidad Estática", R.drawable.raichu)

    PokemonFooter(
        previousPokemon = dummyArbok,
        nextPokemon = dummyRaichu,
        onNavigate = {}
    )
}