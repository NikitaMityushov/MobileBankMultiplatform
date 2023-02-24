package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.mappers

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.AccessAndRefreshTokensDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.OptCodeResponseDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

private const val ACCESS_TOKEN = "12EWDSFBSERR32EWFRF431EQW"
private const val REFRESH_TOKEN = "ALJSDBFGIUA4JORKEWFR4HIU3JOWE"
private const val VALID_PHONE_NUMBER = "+79115552211"
private const val OPT_ID = "1"
private const val OPT_CODE = "OAEURTY9AUOIERMFQ2U"
private const val GUEST_TOKEN = "IAJR9EUFNSDZAJW4IREJWFO"
private const val PASSWORD = "AI348RJWEJNFJ2034U85T5U3N4IHU3I4G"

class MappersTest {

    @Test
    fun toAccessTokenDtoTest() {
        // given
        val tokens = AccessAndRefreshTokens(ACCESS_TOKEN, REFRESH_TOKEN)
        // when
        val result = tokens.toAccessTokenDto()
        // then
        assertNotEquals(REFRESH_TOKEN, result.accessToken)
        assertEquals(ACCESS_TOKEN, result.accessToken)
    }

    @Test
    fun toPhoneNumberDtoTest() {
        // given
        val number = PhoneNumber(VALID_PHONE_NUMBER)
        // when
        val numberDto = number.toPhoneNumberDto()
        // then
        assertNotEquals(ACCESS_TOKEN, numberDto.phone)
        assertEquals(VALID_PHONE_NUMBER, numberDto.phone)
    }

    @Test
    fun toRefreshTokenDtoTest() {
        // given
        val tokens = AccessAndRefreshTokens(ACCESS_TOKEN, REFRESH_TOKEN)
        // when
        val result = tokens.toRefreshTokenDto()
        // then
        assertNotEquals(ACCESS_TOKEN, result.refreshToken)
        assertEquals(REFRESH_TOKEN, result.refreshToken)
    }

    @Test
    fun toSmsCodeDtoTest() {
        // given
        val sms = SmsCode(PhoneNumber(VALID_PHONE_NUMBER), OptCode(OPT_ID, OPT_CODE))
        // when
        val result = sms.toSmsCodeDto()
        // then
        assertEquals(OPT_ID, result.optId)
        assertEquals(OPT_CODE, result.optCode)
        assertEquals(VALID_PHONE_NUMBER, result.phone)
        assertNotEquals(REFRESH_TOKEN, result.optId)
        assertNotEquals(REFRESH_TOKEN, result.optCode)
        assertNotEquals(REFRESH_TOKEN, result.phone)
    }

    @Test
    fun toGuestTokenDto() {
        // given
        val token = GuestToken(GUEST_TOKEN, PASSWORD)
        // when
        val result = token.toGuestTokenDto()
        // then
        assertNotEquals(REFRESH_TOKEN, result.guestToken)
        assertEquals(GUEST_TOKEN, result.guestToken)
    }

    @Test
    fun toOptCodeTest() {
        // given
        val response = OptCodeResponseDto(OPT_ID, OPT_CODE, 15)
        // when
        val result = response.toOptCode()
        // then
        assertNotEquals(REFRESH_TOKEN, result.optCode)
        assertNotEquals(REFRESH_TOKEN, result.optId)
        assertEquals(OPT_ID, result.optId)
        assertEquals(OPT_CODE, result.optCode)
    }

    @Test
    fun toAccessAndRefreshTokensTest() {
        // given
        val response = AccessAndRefreshTokensDto(ACCESS_TOKEN, REFRESH_TOKEN)
        // when
        val result = response.toAccessAndRefreshTokens()
        // then
        assertNotEquals(REFRESH_TOKEN, result.accessToken)
        assertNotEquals(ACCESS_TOKEN, result.refreshToken)
        assertEquals(ACCESS_TOKEN, result.accessToken)
        assertEquals(REFRESH_TOKEN, result.refreshToken)
    }
}