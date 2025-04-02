package pl.kosciukw.petsify.feature.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import pl.kosciukw.petsify.feature.login.R
import pl.kosciukw.petsify.shared.ui.components.BackgroundImage
import pl.kosciukw.petsify.shared.ui.components.ButtonContent
import pl.kosciukw.petsify.shared.ui.components.ButtonRegular
import pl.kosciukw.petsify.shared.ui.components.ButtonText
import pl.kosciukw.petsify.shared.ui.components.EditText
import pl.kosciukw.petsify.shared.ui.theme.BlackLiquorice
import pl.kosciukw.petsify.shared.ui.theme.GoshawkGrey
import pl.kosciukw.petsify.shared.ui.theme.PureWhite
import pl.kosciukw.petsify.shared.ui.theme.TextBoldS
import pl.kosciukw.petsify.shared.ui.theme.TextBoldXL
import pl.kosciukw.petsify.shared.ui.theme.TextPrimary
import pl.kosciukw.petsify.shared.ui.theme.TextRegularS
import pl.kosciukw.petsify.shared.ui.theme.TextS
import pl.kosciukw.petsify.shared.ui.theme.paddingGapM
import pl.kosciukw.petsify.shared.ui.theme.paddingL
import pl.kosciukw.petsify.shared.ui.theme.paddingM
import pl.kosciukw.petsify.shared.ui.theme.paddingS
import pl.kosciukw.petsify.shared.ui.theme.paddingXL
import pl.kosciukw.petsify.shared.ui.theme.paddingXXL
import pl.kosciukw.petsify.shared.utils.empty

@Composable
internal fun LoginScreen(
    state: LoginUiState,
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {

    if(state.isLoading) {

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Header(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(32.dp))

        LoginForm(
            onNavigateToMain = onNavigateToMain,
            onNavigateToSignUp = onNavigateToSignUp,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

//@Preview
//@Composable
//private fun PreviewLoginScreen() {
//    PetsifyTheme {
//        LoginScreen(
//            onNavigateToSignUp = {},
//            onNavigateToMain = {}
//        )
//    }
//}

@Composable
private fun Header(modifier: Modifier) {
    Box(modifier = modifier.background(color = MaterialTheme.colorScheme.background)) {
        Image(
            painter = painterResource(id = R.drawable.login_screen_background),
            contentDescription = String.empty(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = paddingXXL),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            TextWithTrailingIcon(
//                label = stringResource(id = R.string.app_name),
//                textStyle = TextPrimary,
//                textColor = GoshawkGrey,
//                resId = R.drawable.ic_paw_color
//            )

            Text(
                text = stringResource(id = R.string.app_name),
                style = TextPrimary,
                color = GoshawkGrey,
                modifier = Modifier.padding(top = paddingGapM)
            )

            BackgroundImage(
                modifier = Modifier.padding(top = paddingS),
                imageId = R.drawable.login_screen_header_image
            )

            Spacer(modifier = Modifier.padding(top = paddingM))
        }
    }
}

@Composable
private fun LoginForm(
    modifier: Modifier = Modifier,
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = paddingL)
    ) {
        Text(
            text = stringResource(id = R.string.login_screen_welcomd_our_community_today),
            style = TextBoldXL,
            color = GoshawkGrey,
            modifier = Modifier.padding(paddingM)
        )

        //Login
        val loginInput = remember { mutableStateOf(String.empty()) }
        EditText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = paddingS),
            trailingIcon = ImageVector.vectorResource(id = R.drawable.ic_paw),
            label = stringResource(id = R.string.login_screen_login_field),
            text = loginInput.value,
            onTextChange = { loginInput.value = it }
        )

        //Password
        val passwordInput = remember { mutableStateOf(String.empty()) }
        EditText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = paddingS),
            trailingIcon = ImageVector.vectorResource(id = R.drawable.ic_bone),
            label = stringResource(id = R.string.login_screen_password_field),
            text = passwordInput.value,
            onTextChange = { passwordInput.value = it }
        )

        Text(
            text = stringResource(id = R.string.login_screen_forgot_password),
            style = TextRegularS.copy(textAlign = TextAlign.End, fontSize = TextS),
            modifier = Modifier
                .padding(vertical = paddingM)
                .fillMaxWidth()
        )

        ButtonRegular(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(top = paddingM),
            style = TextBoldS,
            buttonColors = ButtonDefaults.buttonColors(
                containerColor = BlackLiquorice
            ),
            onClick = onNavigateToMain,
            label = stringResource(id = R.string.login_screen_login_button),
            textColor = PureWhite
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = paddingXL)
        ) {
            Text(
                text = stringResource(id = R.string.login_screen_login_new_to_petsify),
                style = TextRegularS
            )

            ButtonText(
                modifier = Modifier.padding(start = paddingS),
                onClick = onNavigateToSignUp,
                label = stringResource(id = R.string.login_screen_signup),
                style = TextBoldS,
                textColor = GoshawkGrey
            )
        }

        Text(
            text = stringResource(id = R.string.login_screen_or),
            style = TextRegularS,
            modifier = Modifier.padding(vertical = paddingL)
        )

        LoginWithGoogleButton(
            modifier = Modifier
                .padding(top = paddingS, bottom = paddingGapM)
                .height(50.dp)
                .fillMaxWidth()
        ) {
            //no-op now
        }
    }
}

@Composable
private fun LoginWithGoogleButton(
    modifier: Modifier = Modifier,
    style: TextStyle = TextBoldS,
    label: String = stringResource(id = R.string.login_screen_google_login_button),
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.tertiaryContainer
    ),
    onClick: () -> Unit
) {

    ButtonContent(
        modifier = modifier,
        onClick = { onClick() },
        buttonColors = buttonColors,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_google),
                    contentDescription = String.empty(),
                    modifier = Modifier.padding(end = paddingS)
                )
                Text(
                    style = style,
                    text = label,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        }
    )
}