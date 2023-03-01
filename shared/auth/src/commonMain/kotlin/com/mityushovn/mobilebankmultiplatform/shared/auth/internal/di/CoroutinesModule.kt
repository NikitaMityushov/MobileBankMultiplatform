package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.kodein.di.DI
import org.kodein.di.bindSingleton

private const val MODULE_NAME = "COROUTINES_MODULE"

internal val coroutinesModule = DI.Module(MODULE_NAME) {
    bindSingleton<CoroutineDispatcher> {
        Dispatchers.IO
    }
}