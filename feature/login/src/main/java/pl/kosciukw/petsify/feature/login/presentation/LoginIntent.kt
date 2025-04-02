package pl.kosciukw.petsify.feature.login.presentation

sealed class LoginIntent {
    data class EnterEmail(val email: String) : LoginIntent()
    data class EnterPassword(val password: String) : LoginIntent()
    data object SubmitLogin : LoginIntent()
}