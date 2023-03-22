package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.kodein.di.DI
import org.kodein.di.bindSingleton

internal val networkModule = DI.Module(NetworkConfig.MODULE_NAME) {
    bindSingleton<HttpClient> {
        HttpClient(HttpEngineFactory().createEngine()) {
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                    }
                )
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