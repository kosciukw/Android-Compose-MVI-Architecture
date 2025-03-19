package pl.kosciukw.petsify.shared.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun EditTextWithTrailingIcon(
    modifier: Modifier = Modifier,
    label: String,
    icon: ImageVector,
    iconDescription: String = ""
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        shape = RoundedCornerShape(18.dp),
        label = { Text(label) },
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = iconDescription
            )
        },
        modifier = modifier
    )

}