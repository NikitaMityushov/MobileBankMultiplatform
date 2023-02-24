package com.mityushovn.mobilebankmultiplatform.shared.auth.api

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di.ktorApiModule
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di.networkModule
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di.repositoryModule
import org.kodein.di.DI

private const val MODULE_NAME = "ROOT_MODULE"

val authModule = DI.Module(MODULE_NAME) {
    importAll(
        networkModule, repositoryModule, ktorApiModule
    )
}