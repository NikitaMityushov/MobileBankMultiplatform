package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models

import org.junit.Test
import kotlin.test.assertFailsWith

private const val PATTERN = "^\\+7\\d{10}$"
private const val ERROR_MESSAGE = "Invalid phone number"
private const val VALID__PHONE_NUMBER = "+79115552211"
private const val INVALID_PHONE_NUMBER = "12HIEW23"

class PhoneNumberTest {

    @Test
    fun `if doesn't match PATTERN throws IllegalArgumentException`() {
        // given
        // when
        // then
        assertFailsWith<IllegalArgumentException>(message = ERROR_MESSAGE) {
            val number = PhoneNumber(INVALID_PHONE_NUMBER)
        }
    }

    @Test
    fun `if matches PATTERN doesn't throw exception`() {
        // given
        val invalidNumber = "12312"
        // when
        val number = PhoneNumber(VALID__PHONE_NUMBER)
        // then doesn't throw exception
    }
}