package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import com.russhwolf.settings.Settings

internal expect class SettingsFactory {
    fun createSettings(): Settings
}