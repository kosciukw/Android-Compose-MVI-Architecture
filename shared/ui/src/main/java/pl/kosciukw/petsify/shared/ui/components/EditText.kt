package pl.kosciukw.petsify.shared.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kosciukw.petsify.shared.ui.theme.TextRegularS
import pl.kosciukw.petsify.shared.ui.theme.TextS
import pl.kosciukw.petsify.shared.ui.theme.TextSecondary
import androidx.compose.material3.OutlinedTextField
import pl.kosciukw.petsify.shared.utils.empty

@Composable
fun EditText(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    trailingIcon: ImageVector,
    iconDescription: String = String.empty(),
    labelTextStyle: TextStyle = TextSecondary.copy(
        fontSize = TextS,
        textAlign = TextAlign.Start
    ),
    inputTextStyle: TextStyle = TextRegularS.copy(textAlign = TextAlign.Start)
) {
    TextField(
        modifier = modifier,
        value = text,
        singleLine = true,
        onValueChange = onTextChange,
        shape = RoundedCornerShape(18.dp),
        label = {
            Text(
                style = labelTextStyle,
                text = label
            )
        },
        textStyle = inputTextStyle,
        trailingIcon = {
            Icon(
                imageVector = trailingIcon,
                contentDescription = iconDescription
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = MaterialTheme.colorScheme.secondary,
            focusedBorderColor = MaterialTheme.colorScheme.surface,
            unfocusedBorderColor = MaterialTheme.colorScheme.surface
        ),
    )
}

@Composable
fun EditTextOutline(
    modifier: Modifier = Modifier,
    text: String,
    onTextChange: (String) -> Unit,
    label: String,
    icon: ImageVector,
    iconDescription: String = String.empty(),
    labelTextStyle: TextStyle = TextSecondary.copy(
        fontSize = TextS,
        textAlign = TextAlign.Start
    ),
    inputTextStyle: TextStyle = TextRegularS.copy(
        textAlign = TextAlign.Start
    )
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        singleLine = true,
        onValueChange = onTextChange,
        shape = RoundedCornerShape(18.dp),
        label = {
            Text(
                style = labelTextStyle,
                text = label
            )
        },
        textStyle = inputTextStyle,
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        }
    )
}
