package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.apis

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.AccessTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.PhoneNumberDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.RefreshTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.SmsCodeDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.AccessAndRefreshTokensDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.GuestTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.OptCodeResponseDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

private const val OPT_CODE_ENDPOINT = "/api/auth/login"
private const val GUEST_TOKEN_ENDPOINT = "api/auth/confirm"
private const val TOKEN_FROM_GUEST_ENDPOINT = "api/auth/enter"
private const val TOKEN_FROM_REFRESH_ENDPOINT = "api/auth/refresh"
private const val LOGOUT_ENDPOINT = "api/auth/logout"

internal class KtorAuthApi(
    private val client: HttpClient
) {
    suspend fun getOptCode(phoneNumber: PhoneNumberDto): OptCodeResponseDto = client.post {
        url {
            appendPathSegments(OPT_CODE_ENDPOINT)
        }

        setBody(phoneNumber)
    }.body()

    suspend fun  getGuestToken(smsCode: SmsCodeDto): GuestTokenDto = client.post {
        url {
            appendPathSegments(GUEST_TOKEN_ENDPOINT)
        }

        setBody(smsCode)
    }.body()

    suspend fun getAccessAndRefreshTokenFromGuestToken(guestToken: GuestTokenDto): AccessAndRefreshTokensDto = client.post {
        url {
            appendPathSegments(TOKEN_FROM_GUEST_ENDPOINT)
        }
        setBody(guestToken)
    }.body()

    suspend fun getAccessAndRefreshTokensFromRefreshToken(refreshToken: RefreshTokenDto): AccessAndRefreshTokensDto = client.post {
        url {
            appendPathSegments(TOKEN_FROM_REFRESH_ENDPOINT)
        }

        setBody(refreshToken)
    }.body()

    suspend fun logout(accessTokenDto: AccessTokenDto): HttpResponse = client.post {
        url {
            appendPathSegments(LOGOUT_ENDPOINT)
        }

        setBody(accessTokenDto)
    }.body()
}