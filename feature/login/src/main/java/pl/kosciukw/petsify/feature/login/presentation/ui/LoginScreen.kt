package pl.kosciukw.petsify.feature.login.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.Flow
import pl.kosciukw.petsify.feature.login.R
import pl.kosciukw.petsify.feature.login.presentation.LoginEvent
import pl.kosciukw.petsify.feature.login.presentation.LoginState
import pl.kosciukw.petsify.shared.ui.components.BackgroundImage
import pl.kosciukw.petsify.shared.ui.components.ButtonRegular
import pl.kosciukw.petsify.shared.ui.components.ButtonText
import pl.kosciukw.petsify.shared.ui.components.DefaultScreenUI
import pl.kosciukw.petsify.shared.ui.components.EditText
import pl.kosciukw.petsify.shared.ui.components.UIComponent
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
    state: LoginState,
    onNavigateToMain: () -> Unit,
    onNavigateToSignUp: () -> Unit,
    errors: Flow<UIComponent>,
    events: (LoginEvent) -> Unit
) {
    DefaultScreenUI(
        errors = errors,
        progressBarState = state.progressBarState,
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Header(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.size(paddingGapM))

                LoginForm(
                    onNavigateToMain = onNavigateToMain,
                    onNavigateToSignUp = onNavigateToSignUp,
                    modifier = Modifier.fillMaxWidth(),
                    onEmailTextChanged = { email ->
                        events(LoginEvent.OnEmailTextChanged(email))
                    },
                    onPasswordTextChanged = { password ->
                        events(LoginEvent.OnPasswordTextChanged(password))
                    },
                    state = state
                )
            }
        }
    )
}

@Composable
private fun Header(modifier: Modifier) {
    Box(modifier = modifier.background(color = MaterialTheme.colorScheme.surfaceContainer)) {
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
//           )

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
    onNavigateToSignUp: () -> Unit,
    onEmailTextChanged: (String) -> Unit,
    onPasswordTextChanged: (String) -> Unit,
    state: LoginState
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

        //Email
        EditText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = paddingS),
            trailingIcon = ImageVector.vectorResource(id = R.drawable.ic_paw),
            label = stringResource(id = R.string.login_screen_email_field),
            text = state.inputEmail,
            onTextChange = { email -> onEmailTextChanged(email) },
            isErrorMessageEnabled = state.isEmailValidationErrorEnabled,
            errorMessage = stringResource(id = R.string.login_screen_email_validation_error),
        )

        //Password
        EditText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = paddingS),
            trailingIcon = ImageVector.vectorResource(id = R.drawable.ic_bone),
            label = stringResource(id = R.string.login_screen_password_field),
            text = state.inputPassword,
            onTextChange = { password -> onPasswordTextChanged(password) },
            errorMessage = stringResource(id = R.string.login_screen_password_validation_error),
            isErrorMessageEnabled = state.isPasswordValidationErrorEnabled
        )

        Text(
            text = stringResource(id = R.string.login_screen_forgot_password),
            style = TextRegularS.copy(textAlign = TextAlign.End, fontSize = TextS),
            modifier = Modifier
                .padding(vertical = paddingM)
                .fillMaxWidth()
        )

        //Login Button
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
            textColor = PureWhite,
            isButtonEnabled = state.isLoginButtonEnabled
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
                .fillMaxWidth()
                .height(50.dp)
                .padding(top = paddingM),
            style = TextBoldS,
            onClick = onNavigateToMain,
            label = stringResource(id = R.string.login_screen_google_login_button),
            isButtonEnabled = true,
            painter = painterResource(id = R.drawable.ic_google)
        )

        Spacer(modifier = Modifier.size(paddingGapM))
    }
}

@Composable
private fun LoginWithGoogleButton(
    modifier: Modifier = Modifier,
    style: TextStyle = TextBoldS,
    label: String,
    painter: Painter,
    contentDescription: String = label,
    iconPadding: Dp = paddingS,
    borderColor: Color = MaterialTheme.colorScheme.outline,
    borderWidth: Dp = 1.dp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
    isButtonEnabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = buttonColors,
        modifier = modifier
            .border(
                width = borderWidth,
                color = borderColor,
                shape = RoundedCornerShape(22.dp)
            )
            .height(50.dp)
            .fillMaxWidth(),
        enabled = isButtonEnabled
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.padding(end = iconPadding)
            )
            Text(
                style = style,
                text = label,
                color = textColor
            )
        }
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