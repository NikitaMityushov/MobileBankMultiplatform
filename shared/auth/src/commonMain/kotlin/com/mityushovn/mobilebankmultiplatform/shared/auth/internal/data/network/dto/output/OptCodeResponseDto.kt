package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output

@kotlinx.serialization.Serializable
internal data class OptCodeResponseDto(
    val optId: String,
    val optCode: String,
    val optLen: Int
)
