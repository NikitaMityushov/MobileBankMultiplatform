package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import com.russhwolf.settings.Settings
import org.kodein.di.DI
import org.kodein.di.bindSingleton

private const val SETTINGS_MODULE_NAME = "SETTINGS_MODULE"

internal val settingsModule = DI.Module(SETTINGS_MODULE_NAME) {
//    bindSingleton<Settings> {
//        SettingsFactory().createSettings()
//    }
}