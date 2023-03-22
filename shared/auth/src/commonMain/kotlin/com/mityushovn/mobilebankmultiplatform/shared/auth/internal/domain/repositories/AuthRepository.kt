package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories

import arrow.core.Either
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.BankError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.*

interface AuthRepository {

    suspend fun getOtpCode(phoneNumber: PhoneNumber): Either<BankError, OtpCode>

    suspend fun getGuestToken(smsCode: SmsCode): Either<BankError, String>

    suspend fun getAccessAndRefreshTokenFromGuestToken(guestToken: GuestToken): Either<BankError, AccessAndRefreshTokens>

    suspend fun getAccessAndRefreshTokensFromRefreshToken(refreshToken: AccessAndRefreshTokens): Either<BankError, AccessAndRefreshTokens>

    suspend fun logout(tokens: AccessAndRefreshTokens): Either<BankError, Boolean>
}