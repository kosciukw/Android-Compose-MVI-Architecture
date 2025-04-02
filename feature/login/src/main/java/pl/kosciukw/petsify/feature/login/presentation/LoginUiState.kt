package pl.kosciukw.petsify.feature.login.presentation

import androidx.compose.runtime.Immutable

@Immutable
data class LoginUiState(
    val isLoading: Boolean = false,
    val email: String = "",
    val password: String = "",
    val isLoggedIn: Boolean = false,
    val shouldShowEmptyValidationError: Boolean = false
)