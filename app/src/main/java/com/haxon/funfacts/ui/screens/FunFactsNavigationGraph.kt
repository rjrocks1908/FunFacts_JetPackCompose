package com.haxon.funfacts.ui.screens

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.haxon.funfacts.ui.UserInputViewModel
import com.haxon.funfacts.ui.screens.Routes.ANIMAL_SELECTED
import com.haxon.funfacts.ui.screens.Routes.USERNAME

@Composable
fun FunFactsNavigationGraph(userInputViewModel: UserInputViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN) {
        composable(Routes.USER_INPUT_SCREEN) {
            UserInputScreen(userInputViewModel) {
                navController.navigate("${Routes.WELCOME_SCREEN}/${it.first}/${it.second}")
            }
        }

        composable("${Routes.WELCOME_SCREEN}/{${USERNAME}}/{${ANIMAL_SELECTED}}",
            arguments = listOf(
                navArgument(name = USERNAME) {type = NavType.StringType},
                navArgument(name = ANIMAL_SELECTED) {type = NavType.StringType}
            )
        ) {
            val username = it.arguments?.getString(USERNAME)
            val animalSelected = it.arguments?.getString(ANIMAL_SELECTED)
            WelcomeScreen(username, animalSelected)
        }
    }
}