package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.repositories

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.apis.KtorAuthApi
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.PhoneNumberDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.RefreshTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.input.SmsCodeDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.AccessAndRefreshTokensDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.GuestTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.OptCodeResponseDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlin.test.*

private const val VALID_RESULT_PHONE_NUMBER = "+79115552211"
private const val OPT_CODE = "111"
private const val OPT_ID = "3"
private const val OPT_LEN = 3
private const val GUEST_TOKEN = "U23HRU29839283WEJF823"
private const val PASSWORD = "QWERTY123"
private const val ACCESS_TOKEN = "AKFHIQ2UH34293FUERDF"
private const val REFRESH_TOKEN = "QM3I298EWFJIDCSMFTU4R"
private const val EITHER_ERROR_MESSAGE_RIGHT = "SHOULD BE LEFT"
private const val EITHER_ERROR_MESSAGE_LEFT = "SHOULD BE RIGHT"

@OptIn(ExperimentalCoroutinesApi::class)
internal class KtorAuthRepositoryImplTest {

    @MockK
    lateinit var api: KtorAuthApi

    @InjectMockKs
    lateinit var repository: KtorAuthRepositoryImpl

    @BeforeTest
    fun setUp() {
        MockKAnnotations.init(this)

        coEvery { api.getOptCode(PhoneNumberDto(VALID_RESULT_PHONE_NUMBER)) } returns OptCodeResponseDto(
            OPT_ID, OPT_CODE, OPT_LEN)

        coEvery { api.getGuestToken(SmsCodeDto(OPT_ID, VALID_RESULT_PHONE_NUMBER, OPT_CODE)) } returns GuestTokenDto(
            GUEST_TOKEN)

        coEvery { api.getAccessAndRefreshTokenFromGuestToken(GuestTokenDto(GUEST_TOKEN)) } returns AccessAndRefreshTokensDto(
            ACCESS_TOKEN, REFRESH_TOKEN)

        coEvery { api.getAccessAndRefreshTokensFromRefreshToken(RefreshTokenDto(REFRESH_TOKEN)) } returns AccessAndRefreshTokensDto(
            ACCESS_TOKEN, REFRESH_TOKEN)

//        coEvery { api.logout(AccessTokenDto(ACCESS_TOKEN)) } returns
    }

    @Test
    fun getOptCodeTest() = runTest {
        // given
        // when
        repository
            .getOptCode(PhoneNumber(VALID_RESULT_PHONE_NUMBER))
            .fold(
                { throw Exception(EITHER_ERROR_MESSAGE_LEFT) },
                {
                    assertEquals(OPT_CODE, it.optCode)
                    assertEquals(OPT_ID, it.optId)
                }
            )
    }

    @Test
    @Ignore("mocking of api call doesn't work")
    fun getGuestTokenTest() = runTest {
        // given
        // when
        repository.getGuestToken(SmsCode(PhoneNumber(VALID_RESULT_PHONE_NUMBER), OptCode(OPT_ID, OPT_CODE)))
            .fold(
                { throw Exception(EITHER_ERROR_MESSAGE_LEFT) },
                {
                    // then
                    assertNotEquals(VALID_RESULT_PHONE_NUMBER, it)
                    assertEquals(GUEST_TOKEN, it)
                }
            )
    }

    @Test
    @Ignore("mocking of api call doesn't work")
    fun getAccessAndRefreshTokenFromGuestTokenTest() = runTest {
        // given
        // when
        repository.getAccessAndRefreshTokenFromGuestToken(GuestToken(GUEST_TOKEN, PASSWORD))
            .fold(
                { throw Exception(EITHER_ERROR_MESSAGE_LEFT) },
                {
                    // then
                    assertNotEquals(VALID_RESULT_PHONE_NUMBER, it.accessToken)
                    assertEquals(ACCESS_TOKEN,  it.accessToken)
                    assertNotEquals(GUEST_TOKEN, it.refreshToken)
                    assertEquals(REFRESH_TOKEN, it.refreshToken)
                }
            )
    }

    @Test
    @Ignore("mocking of api call doesn't work")
    fun getAccessAndRefreshTokensFromRefreshTokenTest() = runTest {
        // given
        // when
        repository.getAccessAndRefreshTokensFromRefreshToken(AccessAndRefreshTokens(ACCESS_TOKEN, REFRESH_TOKEN))
            .fold(
                { throw Exception(EITHER_ERROR_MESSAGE_LEFT) },
                {
                    // then
                    assertNotEquals(GUEST_TOKEN, it.accessToken)
                    assertEquals(ACCESS_TOKEN, it.accessToken)
                    assertNotEquals(GUEST_TOKEN, it.accessToken)
                    assertEquals(REFRESH_TOKEN, it.refreshToken)
                }
            )
    }

    @Test
    @Ignore("should mock logout")
    fun logoutTest() = runTest {
        // given
        // when
        repository.logout(AccessAndRefreshTokens(ACCESS_TOKEN, REFRESH_TOKEN))
            .fold(
                { throw Exception(EITHER_ERROR_MESSAGE_LEFT) },
                {
                    // then
                    assertEquals(true, it)
                }
            )
    }
}