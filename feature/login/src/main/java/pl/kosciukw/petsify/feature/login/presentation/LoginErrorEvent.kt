package pl.kosciukw.petsify.feature.login.presentation

import pl.kosciukw.petsify.shared.error.NetworkError

sealed interface LoginErrorEvent {
    data class Error(val error: NetworkError): LoginErrorEvent
}