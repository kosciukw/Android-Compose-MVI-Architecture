package pl.kosciukw.petsify.feature.login.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import pl.kosciukw.petsify.feature.login.presentation.ui.LoginScreen
import pl.kosciukw.petsify.feature.login.presentation.ui.LoginViewModel

@Serializable
data object LoginDestination

fun NavGraphBuilder.loginScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    composable<LoginDestination> {
        val loginViewModel: LoginViewModel = hiltViewModel()
        val state = loginViewModel.state.value
        val action = loginViewModel.action

        LoginScreen(
            state = state,
            onNavigateToMain = onNavigateToMain,
            onNavigateToSignUp = onNavigateToSignUp,
            errors = loginViewModel.errors,
            events = { event -> loginViewModel.setEvent(event) },
            action = action
        )
    }
}