package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.network.apis.KtorAuthApi
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.data.repositories.KtorAuthRepositoryImpl
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.factory
import org.kodein.di.instance

private const val AUTH_REPOSITORY_MODULE_NAME = "AUTH_REPOSITORY_MODULE"
private const val KTOR_API_MODULE_NAME = "KTOR_API_MODULE"

internal val repositoryModule = DI.Module(AUTH_REPOSITORY_MODULE_NAME) {
    bind<AuthRepository>() with factory {
        KtorAuthRepositoryImpl(instance())
    }
}

internal val ktorApiModule = DI.Module(KTOR_API_MODULE_NAME) {
    bind<KtorAuthApi>() with factory {
        KtorAuthApi(instance())
    }
}
