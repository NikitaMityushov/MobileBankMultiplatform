package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input

@kotlinx.serialization.Serializable
internal class SmsCodeDto(
    val optId: String,
    val phone: String,
    val optCode: String
)
