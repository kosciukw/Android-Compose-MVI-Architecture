package pl.kosciukw.petsify.feature.login.presentation

import pl.kosciukw.petsify.shared.data.network.NetworkState
import pl.kosciukw.petsify.shared.ui.components.progress.ProgressBarState
import pl.kosciukw.petsify.shared.ui.components.view.ViewState

data class LoginState(
    val usernameLogin: String = "",
    val passwordLogin: String = "",
//    val isTokenValid: Boolean = false,
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val networkState: NetworkState = NetworkState.Established,
) : ViewState