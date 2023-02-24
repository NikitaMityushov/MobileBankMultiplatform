package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models

private const val PATTERN = "^\\+7\\d{10}$"
private const val ERROR_MESSAGE = "Invalid phone number"

data class PhoneNumber(
    val phoneNumber: String
) {
    init {
        require(phoneNumber.matches(Regex(PATTERN))) {
            ERROR_MESSAGE
        }
    }
}