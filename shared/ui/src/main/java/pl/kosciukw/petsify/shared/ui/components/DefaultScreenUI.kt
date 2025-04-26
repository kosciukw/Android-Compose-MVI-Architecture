package pl.kosciukw.petsify.shared.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import pl.kosciukw.petsify.shared.components.LoadingScreen
import pl.kosciukw.petsify.shared.extensions.appendToMessageQueue
import pl.kosciukw.petsify.shared.extensions.removeHeadMessage
import pl.kosciukw.petsify.shared.ui.components.dialog.CreateUIComponentDialog
import pl.kosciukw.petsify.shared.data.network.NetworkState
import pl.kosciukw.petsify.shared.ui.components.progress.ProgressBarState
import pl.kosciukw.petsify.shared.ui.components.snackbar.ShowSnackbar
import pl.kosciukw.petsify.shared.ui.components.toolbar.ToolbarConfig
import pl.kosciukw.petsify.shared.ui.components.toolbar.ToolbarCustom
import java.util.LinkedList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DefaultScreenUI(
    errors: Flow<UIComponent> = MutableSharedFlow(),
    progressBarState: ProgressBarState = ProgressBarState.Idle,
    networkState: NetworkState = NetworkState.Established,
    content: @Composable () -> Unit,
    toolbarConfig: ToolbarConfig? = null,
    onTryAgain: () -> Unit = {}
) {
    val errorQueue = remember { mutableStateOf(LinkedList<UIComponent>()) }

    Scaffold(
        topBar = { toolbarConfig?.let { config -> ToolbarCustom(config) } }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            content()

            LaunchedEffect(errors) {
                errors.collect { error ->
                    errorQueue.appendToMessageQueue(error)
                }
            }

            if (errorQueue.value.isNotEmpty()) {
                errorQueue.value.peek()?.let { uiComponent ->
                    when (uiComponent) {
                        is UIComponent.Dialog -> {
                            CreateUIComponentDialog(
                                title = uiComponent.title,
                                description = uiComponent.description,
                                onRemoveHeadFromQueue = { errorQueue.removeHeadMessage() }
                            )
                        }

                        is UIComponent.ToastSimple -> {
                            ShowSnackbar(
                                title = uiComponent.title,
                                snackbarVisibleState = true,
                                onDismiss = { errorQueue.removeHeadMessage() },
                                modifier = Modifier.align(Alignment.BottomCenter)
                            )
                        }

                        is UIComponent.None -> {
                            //no-op
                        }
                    }
                }
            }
        }
    }
    if (networkState == NetworkState.Disconnected && progressBarState == ProgressBarState.Idle) {
        // FailedNetworkScreen(onTryAgain = onTryAgain)
    }

    if (progressBarState is ProgressBarState.LoadingWithLogo) {
        // LoadingWithLogoScreen()
    }

    if (progressBarState is ProgressBarState.ScreenLoading || progressBarState is ProgressBarState.FullScreenLoading) {
        LoadingScreen()
    }
}