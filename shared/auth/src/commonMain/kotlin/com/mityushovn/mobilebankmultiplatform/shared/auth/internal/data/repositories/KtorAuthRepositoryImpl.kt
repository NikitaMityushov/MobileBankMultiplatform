package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.repositories

import arrow.core.Either
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers.*
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers.toGuestTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers.toOptCode
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers.toPhoneNumberDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers.toSmsCodeDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.apis.KtorAuthApi
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.BankError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.AccessAndRefreshTokens
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.GuestToken
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.OtpCode
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.PhoneNumber
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.SmsCode
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.utils.handleApiResponse
import io.ktor.http.*

internal class KtorAuthRepositoryImpl(
    private val api: KtorAuthApi
): AuthRepository {
    override suspend fun getOtpCode(phoneNumber: PhoneNumber): Either<BankError, OtpCode> =
        handleApiResponse {
            api.getOptCode(phoneNumber.toPhoneNumberDto()).toOptCode()
        }

    override suspend fun getGuestToken(smsCode: SmsCode): Either<BankError, String> =
        handleApiResponse {
            api.getGuestToken(smsCode.toSmsCodeDto()).guestToken
        }

    override suspend fun getAccessAndRefreshTokenFromGuestToken(guestToken: GuestToken): Either<BankError, AccessAndRefreshTokens> =
        handleApiResponse {
            api.getAccessAndRefreshTokenFromGuestToken(guestToken.toGuestTokenDto()).toAccessAndRefreshTokens()
        }

    override suspend fun getAccessAndRefreshTokensFromRefreshToken(refreshToken: AccessAndRefreshTokens): Either<BankError, AccessAndRefreshTokens> =
        handleApiResponse {
            api.getAccessAndRefreshTokensFromRefreshToken(refreshToken.toRefreshTokenDto()).toAccessAndRefreshTokens()
        }

    override suspend fun logout(tokens: AccessAndRefreshTokens): Either<BankError, Boolean> =
        handleApiResponse {
            val response = api.logout(tokens.toAccessTokenDto())
            return@handleApiResponse response.status == HttpStatusCode.OK
        }
}