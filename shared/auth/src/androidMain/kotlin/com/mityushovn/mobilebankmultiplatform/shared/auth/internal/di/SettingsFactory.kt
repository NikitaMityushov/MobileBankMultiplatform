package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di

import android.content.SharedPreferences
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

internal actual class SettingsFactory(
    private val prefs: SharedPreferences
) {
    actual fun createSettings(): Settings = SharedPreferencesSettings(prefs)
}