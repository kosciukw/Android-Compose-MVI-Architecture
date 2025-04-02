package pl.kosciukw.petsify.feature.login.presentation

import pl.kosciukw.petsify.shared.data.network.NetworkState
import pl.kosciukw.petsify.shared.ui.components.view.ViewEvent

sealed class LoginEvent : ViewEvent {
//    data class OnUpdateNameRegister(val value: String) : LoginEvent()
    data class OnUpdateUsernameLogin(val value: String) : LoginEvent()
    data class OnUpdatePasswordLogin(val value: String) : LoginEvent()

//    data object Register : LoginEvent()
    data object Login : LoginEvent()

    data object OnRetryNetwork : LoginEvent()
    data class OnUpdateNetworkState(val networkState: NetworkState) : LoginEvent()
}