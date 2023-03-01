package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import org.kodein.di.DI

internal val authDI = DI {
    importAll(
        networkModule, repositoryModule, ktorApiModule, coroutinesModule
    )
}