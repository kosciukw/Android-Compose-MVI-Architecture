package pl.kosciukw.petsify.feature.login.presentation.ui

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pl.kosciukw.petsify.feature.login.domain.EmailIdentifierValidator
import pl.kosciukw.petsify.feature.login.presentation.LoginAction
import pl.kosciukw.petsify.feature.login.presentation.LoginEvent
import pl.kosciukw.petsify.feature.login.presentation.LoginState
import pl.kosciukw.petsify.feature.login.usecase.LoginUseCase
import pl.kosciukw.petsify.shared.data.network.NetworkState
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import pl.kosciukw.petsify.shared.ui.components.progress.ProgressBarState
import pl.kosciukw.petsify.shared.ui.components.viewmodel.BaseViewModel
import pl.kosciukw.petsify.shared.utils.clear
import pl.kosciukw.petsify.shared.validator.EmailIdentifier
import pl.kosciukw.petsify.shared.validator.IdentifierState
import pl.kosciukw.petsify.shared.validator.notempty.NotEmptyValidator
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val emailIdentifierValidator: EmailIdentifierValidator,
    private val notEmptyValidator: NotEmptyValidator<CharArray>
) : BaseViewModel<LoginEvent, LoginState, LoginAction>() {

    override fun setInitialState() = LoginState()
    private var identifierState: IdentifierState = IdentifierState.Invalid
    private var isPasswordValid: Boolean = false
    private var isEmailValid: Boolean = false

    override fun onTriggerEvent(event: LoginEvent) {

        when (event) {
            is LoginEvent.Login -> {
                val email = event.email
                val password = event.password
                login(email, password)
            }

            is LoginEvent.OnEmailTextChanged -> {
                onEmailTextChanged(event.value.toCharArray())
            }

            is LoginEvent.OnPasswordTextChanged -> {
                onPasswordTextChanged(event.value.toCharArray())
            }

            is LoginEvent.OnRetryNetwork -> {
                onRetryNetwork()
            }

            is LoginEvent.OnUpdateNetworkState -> {
                onUpdateNetworkState(event.networkState)
            }
        }
    }

    private fun login(
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            loginUseCase.action(
                LoginUseCase.Params(
                    email,
                    password
                )
            ).collect { result ->
                when (result) {
                    is ResultOrFailure.Loading -> {
                        _state.value = _state.value.copy(
                            progressBarState = ProgressBarState.ScreenLoading
                        )
                    }

                    is ResultOrFailure.Success -> {
                        println("TEST_TAG success")
                        _state.value = _state.value.copy(
                            progressBarState = ProgressBarState.Idle
                        )

                        setAction {
                            LoginAction.Navigation.NavigateToMain
                        }
                    }

                    is ResultOrFailure.Failure -> {
                        println("TEST_TAG failure: ${result.error.message}")

                        _state.value = _state.value.copy(
                            progressBarState = ProgressBarState.Idle
                        )
                    }
                }
            }
        }
    }


    private fun onPasswordTextChanged(password: CharArray) {
        isPasswordValid = notEmptyValidator.isValid(password)
        setState {
            copy(
                inputPassword = password.concatToString(),
                isPasswordValidationErrorEnabled = !isPasswordValid
            )
        }

        password.clear()
        handleButtonState()
    }

    private fun onEmailTextChanged(email: CharArray) {
        EmailIdentifier(email = email).also { identifier ->
            identifierState = emailIdentifierValidator.isValid(identifier = identifier)
        }

        isEmailValid = identifierState is IdentifierState.Valid
        setState {
            copy(
                inputEmail = email.concatToString(),
                isEmailValidationErrorEnabled = !isEmailValid
            )
        }
        handleButtonState()
    }

    private fun handleButtonState() {
        setState { copy(isLoginButtonEnabled = isPasswordValid && isEmailValid) }
    }

    private fun onRetryNetwork() {}

    private fun onUpdateNetworkState(networkState: NetworkState) {
        setState { copy(networkState = networkState) }
    }
}