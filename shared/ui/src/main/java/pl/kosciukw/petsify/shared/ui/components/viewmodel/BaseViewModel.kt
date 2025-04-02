package pl.kosciukw.petsify.shared.ui.components.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import pl.kosciukw.petsify.shared.data.DataState
import pl.kosciukw.petsify.shared.data.network.NetworkState
import pl.kosciukw.petsify.shared.ui.components.UIComponent
import pl.kosciukw.petsify.shared.ui.components.progress.ProgressBarState
import pl.kosciukw.petsify.shared.ui.components.view.ViewEvent
import pl.kosciukw.petsify.shared.ui.components.view.ViewSingleAction
import pl.kosciukw.petsify.shared.ui.components.view.ViewState


abstract class BaseViewModel<Event : ViewEvent, UiState : ViewState, SingleAction : ViewSingleAction> : ViewModel() {

    abstract fun setInitialState(): UiState
    abstract fun onTriggerEvent(event: Event)

    private val initialState: UiState by lazy { setInitialState() }
    private val _state: MutableState<UiState> = mutableStateOf(initialState)
    val state = _state

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()

    // Channel for emitting single actions (if needed)
    private val _action: Channel<SingleAction> = Channel()
    val action = _action.receiveAsFlow()

    // Channel for emitting UI errors (Dialogs, Toasts, etc.)
    private val _errors: MutableSharedFlow<UIComponent> = MutableSharedFlow()
    val errors = _errors.asSharedFlow()

    init {
        subscribeToEvents()
    }

    // Subscribe to events emitted to the ViewModel
    private fun subscribeToEvents() {
        viewModelScope.launch {
            _event.collect {
                onTriggerEvent(it)
            }
        }
    }

    // Set event to trigger the logic in the ViewModel
    fun setEvent(event: Event) {
        viewModelScope.launch { _event.emit(event) }
    }

    // Update the UI state using a reducer function
    protected fun setState(reducer: UiState.() -> UiState) {
        val newState = state.value.reducer()
        _state.value = newState
    }

    // Send single action to be processed by the UI
    protected fun setAction(builder: () -> SingleAction) {
        val effectValue = builder()
        viewModelScope.launch { _action.send(effectValue) }
    }

    // Send an error (UIComponent) to be displayed in the UI
    protected fun setError(builder: () -> UIComponent) {
        val effectValue = builder()
        viewModelScope.launch {
            _errors.emit(effectValue)  // Emit error to be displayed in UI
        }
    }

    fun <T> executeUseCase(
        flow: Flow<DataState<T>>,
        onSuccess: (T?) -> Unit,
        onLoading: (ProgressBarState) -> Unit,
        onNetworkStatus: (NetworkState) -> Unit = {}
    ) {
        viewModelScope.launch {
            flow.collectLatest { dataState ->
                when (dataState) {
                    is DataState.NetworkStatus -> onNetworkStatus(dataState.networkState)
                    is DataState.Response -> setError { dataState.uiComponent }  // Error handling
                    is DataState.Data -> onSuccess(dataState.data)  // Handle success
                    is DataState.Loading -> onLoading(dataState.progressBarState)  // Handle loading state
                }
            }
        }
    }
}