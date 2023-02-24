package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import io.ktor.client.engine.*

internal expect class HttpEngineFactory constructor() {
    fun createEngine(): HttpClientEngineFactory<HttpClientEngineConfig>
}