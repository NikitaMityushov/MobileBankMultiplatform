package com.mityushovn.mobilebankmultiplatform.android.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme

@Composable
fun OtpCodeTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    isOptCodeWrong: Boolean
) {
    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(6) { index ->
                    val char = when {
                        index >= value.length -> ""
                        else -> value[index].toString()
                    }
                    val isFocused = value.length == index

                    Text(
                        modifier = modifier
                            .width(40.dp)
                            .border(
                                if (isFocused) 2.dp
                                else 1.dp,
                                if (isFocused) BankTheme.colors.contentAccentPrimary
                                else BankTheme.colors.contentSecondary,
                                RoundedCornerShape(12.dp)
                            )
                            .background(color = BankTheme.colors.contentSecondary),
                        text = char,
                        style = BankTheme.typography.subtitle_1_20_semibold,
                        color = if (!isOptCodeWrong) BankTheme.colors.textPrimary else BankTheme.colors.indicatorContendError,
                        textAlign = TextAlign.Center,
                    )

                    if (index < 5) {
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }
    )
}

@Preview
@Composable
internal fun OtpCodeTextFieldPreview() {
    var value = remember { "" }
    val onValueChange = { str: String -> value = str }

    BankTheme {
        OtpCodeTextField(value = value, onValueChange = onValueChange, isOptCodeWrong = true)
    }
}