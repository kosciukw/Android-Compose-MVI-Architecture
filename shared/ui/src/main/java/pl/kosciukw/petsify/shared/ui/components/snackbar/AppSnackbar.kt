package pl.kosciukw.petsify.shared.ui.components.snackbar

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.kosciukw.petsify.shared.ui.theme.BodyM

@Composable
fun AppSnackbar(
    modifier: Modifier,
    isSnackbarVisible: Boolean,
    title: String,
    onDismiss: () -> Unit
) {
    if (isSnackbarVisible) {
        Snackbar(
            modifier = modifier
                .padding(BodyM),
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            action = {
                TextButton(onClick = onDismiss) {
                    Text(
                        text = "OK", // TODO: move to strings.xml
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}