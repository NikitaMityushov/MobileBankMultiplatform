package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation

import kotlinx.coroutines.flow.StateFlow

expect class PhoneNumberViewModel {
    val uiState: StateFlow<PhoneNumberUiState>
}

data class PhoneNumberUiState(
    var input: String = "",
    var isLoading: Boolean = false,
    var isInvalidPhoneNumberError: Boolean = false,
    var isPhoneNumberNotRegisteredError: Boolean = false
)
