package pl.kosciukw.petsify.feature.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pl.kosciukw.petsify.feature.login.usecase.LoginUseCase
import pl.kosciukw.petsify.shared.result.ResultOrFailure
import javax.inject.Inject


class PlaceHolder @Inject constructor()

@HiltViewModel
class LoginViewModel @Inject constructor(
//    val placeHolder: PlaceHolder
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiState())
    val state: StateFlow<LoginUiState> = _state.asStateFlow()

//    fun handleIntent(intent: LoginIntent) {
//        when (intent) {
//            is LoginIntent.EnterEmail -> _state.update { it.copy(email = intent.email) }
//            is LoginIntent.EnterPassword -> _state.update { it.copy(password = intent.password) }
//            is LoginIntent.SubmitLogin -> login()
//        }
//    }

//    private fun login() {
//        val currentState = _state.value
//        if (currentState.email.isBlank() || currentState.password.isBlank()) {
//            _state.update { it.copy(shouldShowEmptyValidationError = true) }
//            return
//        }
//
//        viewModelScope.launch {
//            loginUseCase.action(
//                LoginUseCase.Params(
//                    currentState.email,
//                    currentState.password
//                )
//            ).collect { result ->
//                when (result) {
//                    is ResultOrFailure.Loading -> _state.update { it.copy(isLoading = true) }
//                    is ResultOrFailure.Success -> _state.update {
//                        it.copy(
//                            isLoading = false,
//                            isLoggedIn = true
//                        )
//                    }
//
//                    is ResultOrFailure.Failure -> _state.update { it.copy(isLoading = false) }
//                }
//            }
//        }
//    }
}