package pl.kosciukw.petsify.feature.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pl.kosciukw.petsify.shared.ui.components.BackgroundImage
import pl.kosciukw.petsify.shared.ui.components.ButtonRegular
import pl.kosciukw.petsify.shared.ui.components.ClickableText
import pl.kosciukw.petsify.shared.ui.components.EditTextWithTrailingIcon
import pl.kosciukw.petsify.shared.ui.theme.PetsifyTheme
import pl.kosciukw.petsify.shared.ui.theme.TextBoldM
import pl.kosciukw.petsify.shared.ui.theme.TextBoldXL
import pl.kosciukw.petsify.shared.ui.theme.TextRegularS
import pl.kosciukw.petsify.shared.ui.theme.paddingM

@Composable
internal fun LoginScreen(
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
              .fillMaxSize()
              .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
//                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
                //contentAlignment = Alignment.TopCenter
            ) {

                BackgroundImage(
                    modifier = Modifier.padding(top = 32.dp),
                    imageId = R.drawable.login_screen_header_image
                )

                Text(
                    text = "Petsify",
                    style = TextBoldXL,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 32.dp)
                )

                Text(
                    text = "Join our pet community today!",
                    style = TextRegularS,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 16.dp)
                )

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    EditTextWithTrailingIcon(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(paddingM),
                        icon = Icons.Filled.Search,
                        iconDescription = "",
                        label = "Login"
                    )

                    EditTextWithTrailingIcon(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(paddingM),
                        icon = Icons.Filled.Search,
                        iconDescription = "",
                        label = "Password"
                    )

                    ButtonRegular(
                        modifier = Modifier
                          .fillMaxWidth()
                          .padding(paddingM),
                        style = TextBoldM,
                        onClick = onNavigateToMain,
                        label = "Login"
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            modifier = Modifier
                                .padding(paddingM),
                            text = "New to Petsify?",
                            style = TextRegularS
                        )

                        ClickableText(
                            modifier = Modifier
                                .padding(paddingM),
                            onClick = onNavigateToSignUp,
                            label = "Sign up",
                            style = TextBoldM
                        )
                    }
                }

            }

//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f),
//                contentAlignment = Alignment.Center
//            ) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                    EditTextWithTrailingIcon(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(paddingM),
//                        icon = Icons.Filled.Search,
//                        iconDescription = "",
//                        label = "Login"
//                    )
//
//                    EditTextWithTrailingIcon(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(paddingM),
//                        icon = Icons.Filled.Search,
//                        iconDescription = "",
//                        label = "Password"
//                    )
//
//                    ButtonRegular(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(paddingM),
//                        style = MaterialTheme.typography.bodyMedium,
//                        onClick = onNavigateToMain,
//                        label = "Login"
//                    )
//
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        Text(
//                            modifier = Modifier
//                                .padding(paddingM),
//                            text = "New to Petsify?"
//                        )
//
//                        ClickableText(
//                            modifier = Modifier
//                                .padding(paddingM),
//                            onClick = onNavigateToSignUp,
//                            label = "Sign up"
//                        )
//                    }
//                }
//            }
        }
    }
}

@Preview
@Composable
private fun PreviewLoginScreen() {
    PetsifyTheme {
        LoginScreen(
            onNavigateToSignUp = {},
            onNavigateToMain = {}
        )
    }
}