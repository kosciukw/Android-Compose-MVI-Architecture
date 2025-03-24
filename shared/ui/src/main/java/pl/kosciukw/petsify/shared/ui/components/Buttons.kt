package pl.kosciukw.petsify.shared.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import pl.kosciukw.petsify.shared.ui.theme.GoshawkGrey
import pl.kosciukw.petsify.shared.ui.theme.TextBoldS

@Composable
fun ButtonRegular(
    modifier: Modifier = Modifier,
    style: TextStyle = TextBoldS,
    label: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer
    ),
    textColor: Color = MaterialTheme.colorScheme.onTertiaryContainer,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = buttonColors,
        modifier = modifier
    ) {
        Text(
            style = style,
            text = label,
            color = textColor
        )
    }
}

@Composable
fun ButtonContent(
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer
    ),
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = buttonColors,
        modifier = modifier
    ) {
        content()
    }
}

@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    textColor: Color = GoshawkGrey,
    style: TextStyle = TextBoldS,
    label: String,
    onClick: () -> Unit
) {
    Text(
        text = label,
        color = textColor,
        style = style,
        modifier = modifier.clickable { onClick() }
    )
}