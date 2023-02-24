package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models

private const val ILLEGAL_FORMAT_OF_TOKENS = "Illegal format of tokens"

data class AccessAndRefreshTokens(
    val accessToken: String,
    val refreshToken: String
) {
    init {
        require(accessToken.isNotEmpty()) {
            ILLEGAL_FORMAT_OF_TOKENS
        }

        require(refreshToken.isNotEmpty()) {
            ILLEGAL_FORMAT_OF_TOKENS
        }
    }
}
