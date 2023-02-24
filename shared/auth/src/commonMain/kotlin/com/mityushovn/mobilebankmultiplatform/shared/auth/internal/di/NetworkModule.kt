package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.singleton

internal val networkModule = DI.Module(NetworkConfig.MODULE_NAME) {
    bind<HttpClient>(HttpEngineFactory().createEngine()) with singleton {
        HttpClient {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json()
            }

            install(HttpTimeout) {
                connectTimeoutMillis = NetworkConfig.CONNECT_TIMEOUT_MILLIS
                requestTimeoutMillis = NetworkConfig.REQUEST_TIMEOUT_MILLIS
            }

            defaultRequest {
                url(NetworkConfig.BASE_URL)
                contentType(ContentType.Application.Json)
            }
        }
    }
}