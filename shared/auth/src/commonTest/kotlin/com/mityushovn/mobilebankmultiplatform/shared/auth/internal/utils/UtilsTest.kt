package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.utils

import androidx.compose.ui.text.AnnotatedString
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.UnknownError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.NetworkError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.ParseError
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.SerializationException
import kotlin.test.*

private const val VALID_RESULT = "ALEISFJDPOAJEFD"
private const val NOT_VALID_RESULT = "aidfjopajner"

@OptIn(ExperimentalCoroutinesApi::class)
class UtilsTest {
    @MockK(relaxed = true)
    lateinit var httpResponse: HttpResponse

    private val validResponse: suspend () -> String = { VALID_RESULT }
    private val unknownErrorResponse: suspend () -> Nothing = { throw Exception() }
    private val serializationErrorResponse: suspend () -> Nothing = { throw SerializationException() }
    private val redirectNetworkErrorResponse: suspend () -> Nothing by lazy { { throw RedirectResponseException(httpResponse, "") } }
    private val clientNetworkErrorResponse: suspend () -> Nothing by lazy { { throw ClientRequestException(httpResponse, "") } }
    private val serverNetworkErrorResponse: suspend () -> Nothing by lazy { { throw ServerResponseException(httpResponse, "") } }

    @BeforeTest
    fun init() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `if func has valid result then returns either right valid result`() = runTest {
        // given
        // when
        handleApiResponse { validResponse.invoke() }.fold(
            { throw Exception("Should return Either.Right == String, not Either.Left") },
            {
                assertNotEquals(NOT_VALID_RESULT, it)
                assertEquals(VALID_RESULT, it)
            }
        )
    }

    @Test
    fun `if func throws exception then returns UnknownError`() = runTest {
        // given
        // when
        handleApiResponse { unknownErrorResponse.invoke() }.fold(
            // then
            {
                assertFalse(it is NetworkError)
                assertTrue(it is UnknownError)
            },
            { throw Exception("Should return Either.Left == UnknownError, not Either.Right") }
        )

    }

    @Test
    fun `if func throws SerializationException then returns ParseError`() = runTest {
        // given
        // when
        handleApiResponse { serializationErrorResponse.invoke() }.fold(
            // then
            {
                assertFalse(it is NetworkError)
                assertTrue(it is ParseError)
            },
            { throw Exception("Should return Either.Left == ParseError, not Either.Right") }
        )
    }

    @Test
//    @Ignore("should mock httpResponse.getCall()")
    fun `if func throws RedirectResponseException then returns NetworkError`() = runTest {
        // given
        // when
        handleApiResponse { redirectNetworkErrorResponse.invoke() }.fold(
            // then
            {
                assertFalse(it is ParseError)
                assertTrue(it is NetworkError)
            },
            { throw Exception("Should return Either.Left == NetworkError, not Either.Right") }
        )
    }

    @Test
    fun `if func throws ServerResponseException then returns NetworkError`() = runTest {
        // given
        // when
        handleApiResponse { serverNetworkErrorResponse.invoke() }.fold(
            // then
            {
                assertFalse(it is ParseError)
                assertTrue(it is NetworkError)
            },
            { throw Exception("Should return Either.Left == NetworkError, not Either.Right") }
        )
    }

    @Test
    fun `if func throws ClientResponseException then returns NetworkError`() = runTest {
        // given
        // when
        handleApiResponse { clientNetworkErrorResponse.invoke() }.fold(
            // then
            {
                assertFalse(it is ParseError)
                assertTrue(it is NetworkError)
            },
            { throw Exception("Should return Either.Left == NetworkError, not Either.Right") }
        )
    }

    @Test
    fun `if string is empty then return empty string`() {
        // 1)
        val str1 = ""
        val result = phoneNumberFilter(AnnotatedString(str1))
        assertEquals("", result.text.text)
    }

}