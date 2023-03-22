package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import arrow.core.Either
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.dto.output.ErrorGuestTokenDto
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.http.*
import kotlinx.serialization.SerializationException

suspend fun <T : Any> handleApiResponse(
    block: suspend () -> T
): Either<BankError, T> {
    return try {
        val response = block.invoke()
        Either.Right(response)
    } catch (e: RedirectResponseException) {
        e.printStackTrace()
        Either.Left(NetworkError)
    } catch (e: ClientRequestException) {
        e.printStackTrace()
        if (e.response.status == HttpStatusCode.Forbidden) {
            Either.Left(OtpCodeIsWrong((e.response.body<ErrorGuestTokenDto>()).remainingAttempts))
        } else {
            Either.Left(NetworkError)
        }
    } catch (e: ServerResponseException) {
        e.printStackTrace()
        Either.Left(NetworkError)
    } catch (e: SerializationException) {
        e.printStackTrace()
        Either.Left(ParseError)
    } catch (e: Exception) {
        e.printStackTrace()
        Either.Left(UnknownError)
    }
}

fun phoneNumberFilter(input: AnnotatedString): TransformedText {
    val trimmed = if (input.text.length > 11) input.text.substring(0..10) else input.text

    val builder = StringBuilder()

    trimmed.forEachIndexed { index, c ->
        when(index) {
            0 -> builder.append("+").append(c)
            1 -> builder.append(" (").append(c)
            4 -> builder.append(") ").append(c)
            7 -> builder.append(" ").append(c)
            9 -> builder.append(" ").append(c)
            else ->  builder.append(c)
        }
    }

    val phoneOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset == 0) return 0
            if (offset == 1) return 2
            if (offset == 2) return 5
            if (offset == 3) return 6
            if (offset == 4) return 7
            if (offset == 5) return 10
            if (offset == 6) return 11
            if (offset == 7) return 12
            if (offset == 8) return 14
            if (offset == 9) return 15
            if (offset == 10) return 17
            if (offset == 11) return 18
            return 18
        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset == 0) return 0
            if (offset == 2) return 1
            if (offset == 5) return 2
            if (offset == 6) return 3
            if (offset == 7) return 4
            if (offset == 10) return 5
            if (offset == 11) return 6
            if (offset == 12) return 7
            if (offset == 14) return 8
            if (offset == 15) return 9
            if (offset == 17) return 10
            if (offset == 18) return 11
            return 11
        }
    }

    return TransformedText(AnnotatedString(builder.toString()), phoneOffsetTranslator)
}