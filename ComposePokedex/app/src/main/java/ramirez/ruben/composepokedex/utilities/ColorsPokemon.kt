package ramirez.ruben.composepokedex.utilities

import androidx.compose.ui.graphics.Color
import ramirez.ruben.composepokedex.domain.Pokemon
import ramirez.ruben.composepokedex.ui.theme.*

fun getColorByType(pokemon: Pokemon): Pair<Color, Color> {
    var color: Color = Normal
    var dark = true
    var textColor: Color

    when {
        pokemon.type.lowercase().contains(other = "normal") -> color = Normal;
        pokemon.type.lowercase().contains(other = "electric") -> {
            color = Electric
            dark = false
        }

        pokemon.type.lowercase().contains(other = "water") -> {
            color = Water
        }

        pokemon.type.lowercase().contains(other = "fire") -> color = Fire
        pokemon.type.lowercase().contains(other = "fairy") -> {
            color = Fairy
            dark = false
        }

        pokemon.type.lowercase().contains(other = "electric") -> {
            color = Electric
            dark = false
        }

        pokemon.type.lowercase().contains(other = "psychic") -> {
            color = Psych
        }

        pokemon.type.lowercase().contains(other = "fighting") -> {
            color = Fight
            dark = false
        }

        pokemon.type.lowercase().contains(other = "ghost") -> color = Ghost
        pokemon.type.lowercase().contains(other = "bug") -> color = Bug
        pokemon.type.lowercase().contains(other = "poison") -> color = Poison
        pokemon.type.lowercase().contains(other = "ground") -> color = Ground
        pokemon.type.lowercase().contains(other = "rock") -> color = Rock
        pokemon.type.lowercase().contains(other = "flying") -> {
            color = Flying
            dark = false
        }

        else -> color = Normal
    }
    return Pair(color, if (dark) offWhite else DarkGray)
}
