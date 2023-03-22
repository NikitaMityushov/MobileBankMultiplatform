package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models

data class OtpCode(
    val optId: String,
    val optCode: String,
    val optLen: String
)