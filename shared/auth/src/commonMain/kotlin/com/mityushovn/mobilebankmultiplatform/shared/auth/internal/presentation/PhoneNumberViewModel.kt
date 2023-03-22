package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation

import kotlinx.coroutines.flow.StateFlow

expect class PhoneNumberViewModel {
    val uiState: StateFlow<PhoneNumberUiState>
}

data class PhoneNumberUiState(
    var input: String = "",
    var isSearchFieldLoading: Boolean = false,
    var isInvalidPhoneNumberError: Boolean = false,
    var isPhoneNumberNotRegisteredError: Boolean = false,
    var isModalSheetVisible: Boolean = false,
    // modal sheet state
    var isOtpCodeWrong: Boolean = false,
    var optCodeTextFields: String = "",
    var isOtpSheetLoading: Boolean = false,
    var navigateToPasswordScreen: Boolean = false
)
