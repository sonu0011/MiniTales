package com.dev.sonu.theme.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.dev.sonu.theme.MiniTalesTheme
import com.dev.sonu.theme.R

@Composable
fun AppTextField(
    value: String,
    @StringRes label: Int,
    hint: String = "",
    onValueChanged: (String) -> Unit,
    isPasswordFieldOnly: Boolean = false,
    isClickOnly: Boolean = false,
    onClick: () -> Unit = {},
    leadingIcon: ImageVector? = null,
    @StringRes error: Int? = null,
    keyBoardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    onDone: () -> Unit = {}
) {

    val focusManager = LocalFocusManager.current

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    if (isClickOnly) {
                        onClick()
                    }
                },
            value = value,
            onValueChange = onValueChanged,
            singleLine = true,
            isError = error != null,
            readOnly = isClickOnly,
            enabled = !isClickOnly,
            supportingText = {
                error?.let {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = it),
                        color = MaterialTheme.colorScheme.error
                    )
                }
            },
            visualTransformation = if (isPasswordFieldOnly) PasswordVisualTransformation() else VisualTransformation.None,
            label = { Text(text = stringResource(id = label)) },
            placeholder = { Text(text = hint) },
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = hint,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            trailingIcon = {
                error?.let {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "error",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            },
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                    onDone()
                }
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyBoardType,
                imeAction = imeAction
            )
        )
    }

}

@Composable
@MiniTalesPreview
private fun AppTextFieldPreview() {
    MiniTalesTheme {
        Surface {
            AppTextField(
                value = "example",
                label = R.string.nav_icon,
                onValueChanged = {},
                error = R.string.nav_icon,
                isPasswordFieldOnly = true
            )
        }
    }
}