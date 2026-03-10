package ramirez.ruben.composepokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import ramirez.ruben.composepokedex.dummies.getPokemon
import ramirez.ruben.composepokedex.dummies.showAllPokemons
import ramirez.ruben.composepokedex.screens.PokedexMenuScreen
import ramirez.ruben.composepokedex.screens.PokemonDetailScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = PokemonList) {
        composable<PokemonList> {
            PokedexMenuScreen(
                showAllPokemons(),
                { id -> navController.navigate(route = PokemonDetail(id = id)) })
        }
        composable<PokemonDetail> {
            backStackEntry ->
            val pokemon: PokemonDetail = backStackEntry.toRoute()
            PokemonDetailScreen(getPokemon(pokemon.id))
        }
    }


}