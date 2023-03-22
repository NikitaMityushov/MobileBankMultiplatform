package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.R
import com.mityushovn.mobilebankmultiplatform.android.ui.components.OtpCodeTextField
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberUiState

@Composable
fun PhoneNumberBottomSheet(
    modifier: Modifier = Modifier,
    uiState: PhoneNumberUiState,
    onValueChanged: (String) -> Unit
) {
    Column(
        modifier = modifier
            .background(BankTheme.colors.textButton)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(21.dp))

        Image(
            painter = painterResource(id = com.mityushovn.mobilebankmultiplatform.android.ui.R.drawable.ic_arrow_swipe),
            contentDescription = "",
            modifier = Modifier.size(24.dp, 7.dp)
        )

        Spacer(modifier = Modifier.height(36.dp))

        Text(
            text = stringResource(id = R.string.sms_confirmation),
            style = BankTheme.typography.body_2_15_regular,
            textAlign = TextAlign.Center,
            color = BankTheme.colors.textPrimary,
        )

        Spacer(modifier = Modifier.height(24.dp))

        OtpCodeTextField(
            value = uiState.optCodeTextFields,
            onValueChange = onValueChanged,
            isOptCodeWrong = uiState.isOtpCodeWrong
        )

        Spacer(modifier = Modifier.height(50.dp))

        if (uiState.isOtpCodeWrong) {
            Text(
                text = String.format(stringResource(id = R.string.wrong_opt_code), 4),
                color = BankTheme.colors.indicatorContendError,
                textAlign = TextAlign.Center,
                style = BankTheme.typography.caption_2_11_regular
            )
        }
    }
}
