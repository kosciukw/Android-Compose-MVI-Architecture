package pl.kosciukw.petsify.feature.login.presentation

import pl.kosciukw.petsify.shared.ui.components.view.ViewSingleAction

sealed class LoginAction : ViewSingleAction {

   // data class HandleError(val uiComponent: UIComponent) : LoginAction()

    sealed class Navigation : LoginAction() {

        data object NavigateToMain : Navigation()

        data object NavigateToLogin : Navigation()
    }
}