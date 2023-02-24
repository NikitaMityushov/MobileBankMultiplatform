package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models

private const val ILLEGAL_CREDENTIALS = "Illegal credentials"

data class GuestToken(
    val guestToken: String,
    val password: String
) {
    init {
        require(password.isNotEmpty()) {
            ILLEGAL_CREDENTIALS
        }

        require(guestToken.isNotEmpty()) {
            ILLEGAL_CREDENTIALS
        }
    }
}
