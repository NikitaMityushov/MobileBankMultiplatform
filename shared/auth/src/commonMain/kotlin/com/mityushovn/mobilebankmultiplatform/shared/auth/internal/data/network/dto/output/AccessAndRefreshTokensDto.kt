package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output

@kotlinx.serialization.Serializable
class AccessAndRefreshTokensDto(
    val accessToken: String,
    val refreshToken: String
)
