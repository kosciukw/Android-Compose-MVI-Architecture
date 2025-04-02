package pl.kosciukw.petsify.shared.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

@Composable
fun CircleButton(
    imageVector: ImageVector, // Icon for the button
    onClick: () -> Unit, // Click action
    modifier: Modifier = Modifier, // Optional modifier for customization
    backgroundColor: Color = MaterialTheme.colorScheme.primary, // Default button color
    contentColor: Color = MaterialTheme.colorScheme.onPrimary, // Default icon color
    size: Dp = 48.dp // Default button size
) {
    Surface(
        modifier = modifier.size(size), // Set circular size
        shape = CircleShape, // Makes it round
        color = backgroundColor, // Background color
        shadowElevation = 4.dp // Adds slight shadow for depth
    ) {
        IconButton(
            onClick = onClick, // Handles button click
            modifier = Modifier.fillMaxSize() // Make it fill the surface
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null, // Accessibility: Set description if needed
                tint = contentColor // Set icon color
            )
        }
    }
}