package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output

@kotlinx.serialization.Serializable
internal data class RefreshResponseDto(
    val accessToken: String,
    val refreshToken: String
)
