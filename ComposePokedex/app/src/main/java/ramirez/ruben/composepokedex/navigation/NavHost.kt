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
import ramirez.ruben.composepokedex.screens.LoginScreen
import ramirez.ruben.composepokedex.screens.RegisterScreen

@Composable
fun PokedexApp() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = Login) {

        composable<Login> {
            LoginScreen(
                onNavigateToMenu = { navController.navigate(route = PokemonList) },
                onNavigateToRegister = { navController.navigate(route = Register) }
            )
        }

        composable<Register> {
            RegisterScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable<PokemonList> {
            PokedexMenuScreen(
                showAllPokemons(),
                { id -> navController.navigate(route = PokemonDetail(id = id)) }
            )
        }

        composable<PokemonDetail> { backStackEntry ->
            val routeInfo: PokemonDetail = backStackEntry.toRoute()
            val currentId = routeInfo.id

            val allPokemons = showAllPokemons()
            val currentIndex = allPokemons.indexOfFirst { it.number == currentId }

            val prevPokemon = if (currentIndex > 0) allPokemons[currentIndex - 1] else null
            val nextPokemon =
                if (currentIndex in 0 until allPokemons.size - 1) allPokemons[currentIndex + 1] else null

            val adjacentPokemons = Pair(prevPokemon, nextPokemon)

            PokemonDetailScreen(
                pokemon = getPokemon(currentId),
                adjacentPokemons = adjacentPokemons,
                onNavigateDetail = { newId -> navController.navigate(route = PokemonDetail(id = newId)) }
            )
        }
    }


}