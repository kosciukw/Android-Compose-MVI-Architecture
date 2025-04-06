package pl.kosciukw.petsify.feature.login.presentation

import pl.kosciukw.petsify.shared.data.network.NetworkState
import pl.kosciukw.petsify.shared.ui.components.progress.ProgressBarState
import pl.kosciukw.petsify.shared.ui.components.view.ViewState

data class LoginState(
    val inputEmail: String = "",
    val inputPassword: String = "",
    val isLoginButtonEnabled: Boolean = false,
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val isEmailValidationErrorEnabled: Boolean = false,
    val isPasswordValidationErrorEnabled: Boolean = false,
    val networkState: NetworkState = NetworkState.Established,
) : ViewState