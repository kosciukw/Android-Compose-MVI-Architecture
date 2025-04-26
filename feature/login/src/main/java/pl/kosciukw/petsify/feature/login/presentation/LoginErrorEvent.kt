package pl.kosciukw.petsify.feature.login.presentation

import pl.kosciukw.petsify.shared.error.DomainError

sealed interface LoginErrorEvent {
    data class Error(val error: DomainError): LoginErrorEvent
}