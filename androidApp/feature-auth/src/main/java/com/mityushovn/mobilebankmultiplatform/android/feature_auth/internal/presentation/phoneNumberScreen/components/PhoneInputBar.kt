package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.utils.phoneNumberFilter

@Composable
fun PhoneInputField(
    inputText: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    isError: Boolean = false
) {
    TextField(
        value = inputText,
        onValueChange = onValueChanged,
        maxLines = 1,
        textStyle = BankTheme.typography.body_2_15_regular,
        visualTransformation = VisualTransformation(::phoneNumberFilter),
        colors = TextFieldDefaults.textFieldColors(
            textColor = if (!isError) BankTheme.colors.textPrimary else BankTheme.colors.indicatorContendError,
            backgroundColor = BankTheme.colors.contentPrimary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        shape = CircleShape,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        leadingIcon = { Image(imageVector = ImageVector.vectorResource(id = com.mityushovn.mobilebankmultiplatform.android.ui.R.drawable.user), contentDescription = "") },
        trailingIcon = {
            if (isLoading) CircularProgressIndicator(modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp
            )
        },
        modifier = modifier
    )
}