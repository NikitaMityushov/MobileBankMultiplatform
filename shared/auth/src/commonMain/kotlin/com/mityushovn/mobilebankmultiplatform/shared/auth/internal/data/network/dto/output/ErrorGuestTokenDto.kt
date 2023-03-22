package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output

@kotlinx.serialization.Serializable
data class ErrorGuestTokenDto(
    val remainingAttempts: Int,
    val code: String
)