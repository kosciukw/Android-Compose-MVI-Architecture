package pl.kosciukw.petsify.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
private data object MainDestination

fun NavGraphBuilder.mainScreen(
) {
  composable<MainDestination> {
    MainScreen()
  }
}

fun NavController.navigateToMain() {
  navigate(MainDestination) {
    popUpTo(0) {
      inclusive = true
    }
  }
}