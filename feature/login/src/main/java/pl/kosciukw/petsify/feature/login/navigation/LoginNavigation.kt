package pl.kosciukw.petsify.feature.login.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import pl.kosciukw.petsify.feature.login.presentation.LoginScreen
import pl.kosciukw.petsify.feature.login.presentation.LoginViewModel

/**
 * We need to keep this public so we can "see" it from the app module,
 * and use it as a starting point/destination.
 */
@Serializable
data object LoginDestination

fun NavGraphBuilder.loginScreen(
  onNavigateToMain: () -> Unit,
  onNavigateToSignUp: () -> Unit
) {
  composable<LoginDestination> {
    val loginViewModel: LoginViewModel = hiltViewModel() // Using hiltViewModel() to get the ViewModel
    val state by loginViewModel.state.collectAsState() // Collecting the state as a state value

    LoginScreen(
      state = state,
      onNavigateToMain = onNavigateToMain,
      onNavigateToSignUp = onNavigateToSignUp
    )
  }
}