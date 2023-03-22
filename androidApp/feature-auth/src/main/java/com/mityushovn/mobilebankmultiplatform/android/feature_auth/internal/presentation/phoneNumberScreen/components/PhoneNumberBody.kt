package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberUiState
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberViewModel

@Composable
fun PhoneNumberBody(
    modifier: Modifier = Modifier,
    viewModel: PhoneNumberViewModel,
    uiState: State<PhoneNumberUiState>,
    focusManager: FocusManager
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        PhoneInputField(
            modifier = Modifier
                .fillMaxWidth(),
            onValueChanged = { viewModel.inputChanged(it) },
            inputText = uiState.value.input,
            isLoading = uiState.value.isSearchFieldLoading,
            isError = uiState.value.isInvalidPhoneNumberError || uiState.value.isPhoneNumberNotRegisteredError
        )

        Button(
            onClick = {
                viewModel.buttonPressed()
                focusManager.clearFocus()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = CircleShape
        ) {
            Text(text = "Войти")
        }
    }
}