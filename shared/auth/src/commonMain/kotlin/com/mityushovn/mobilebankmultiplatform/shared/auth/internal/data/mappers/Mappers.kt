package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.AccessTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.PhoneNumberDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.RefreshTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.SmsCodeDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.AccessAndRefreshTokensDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.GuestTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.OptCodeResponseDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.*

internal fun AccessAndRefreshTokens.toAccessTokenDto() = AccessTokenDto(
    accessToken = accessToken
)

internal fun PhoneNumber.toPhoneNumberDto(): PhoneNumberDto = PhoneNumberDto(phone = phoneNumber)

internal fun AccessAndRefreshTokens.toRefreshTokenDto(): RefreshTokenDto = RefreshTokenDto(
    refreshToken = refreshToken
)

internal fun SmsCode.toSmsCodeDto() = SmsCodeDto(
    optId = optCode.optId,
    phone = phoneNumber.phoneNumber,
    optCode = optCode.optCode
)


internal fun GuestToken.toGuestTokenDto(): GuestTokenDto = GuestTokenDto(
    guestToken
)

internal fun OptCodeResponseDto.toOptCode(): OptCode = OptCode(optId, optCode)

internal fun AccessAndRefreshTokensDto.toAccessAndRefreshTokens() = AccessAndRefreshTokens(
    accessToken, refreshToken
)
