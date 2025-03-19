package pl.kosciukw.petsify.shared.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun ButtonRegular(
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    label: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = Color(0xFFEBEBEB)
    ),
    onClick: () -> Unit
) {
    androidx.compose.material3.Button(
        colors = buttonColors,
        modifier = modifier,
        onClick = { onClick() }) {
        Text(
            style = style,
            text = label,
            color = Color.Black
        )
    }
}

@Composable
fun ClickableText(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    label: String,
    onClick: () -> Unit
) {
    Text(
        text = label,
        color = color,
        style = style,
        modifier = modifier
            .clickable { onClick() }
    )
}

