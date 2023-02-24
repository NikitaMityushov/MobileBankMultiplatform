package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.utils

import arrow.core.Either
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.BankError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.NetworkError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.ParseError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.UnknownError
import io.ktor.client.plugins.*
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
        Either.Left(NetworkError)
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