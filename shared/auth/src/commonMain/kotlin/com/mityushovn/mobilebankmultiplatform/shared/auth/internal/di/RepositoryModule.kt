package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.apis.KtorAuthApi
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.repositories.KtorAuthRepositoryImpl
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository
import org.kodein.di.*

private const val AUTH_REPOSITORY_MODULE_NAME = "AUTH_REPOSITORY_MODULE"
private const val KTOR_API_MODULE_NAME = "KTOR_API_MODULE"

internal val repositoryModule = DI.Module(AUTH_REPOSITORY_MODULE_NAME) {
    bindSingleton<AuthRepository> {
        KtorAuthRepositoryImpl(instance())
    }
}

internal val ktorApiModule = DI.Module(KTOR_API_MODULE_NAME) {
    bindSingleton<KtorAuthApi> {
        KtorAuthApi(instance())
    }
}
