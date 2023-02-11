package com.mityushovn.mobilebankmultiplatform.android.ui.theme

import androidx.compose.ui.graphics.Color

/**
 * [BankColors] instance for the light theme
 */
val bankLightColors = BankColors(
    bgPrimary = Color(Constants.LightColors.bgPrimary),
    bgSecondary = Color(Constants.LightColors.bgSecondary),
    contentPrimary = Color(Constants.LightColors.contentPrimary),
    contentSecondary = Color(Constants.LightColors.contentSecondary),
    contentTertiary = Color(Constants.LightColors.contentTertiary),
    contentAccentPrimary = Color(Constants.LightColors.contentAccentPrimary),
    contentAccentSecondary = Color(Constants.LightColors.contentAccentSecondary),
    contentAccentTertiary = Color(Constants.LightColors.contentTertiary),
    textPrimary = Color(Constants.LightColors.textPrimary),
    textSecondary = Color(Constants.LightColors.textSecondary),
    textTertiary = Color(Constants.LightColors.textTertiary),
    indicatorContendError = Color(Constants.LightColors.indicatorContentError),
    indicatorContendDone = Color(Constants.LightColors.indicatorContentDone),
    indicatorContendSuccess = Color(Constants.LightColors.indicatorContentSuccess),
    primaryButton = Color(Constants.LightColors.primaryButton),
    bgBottomMenu = Color(0xFFFFFFFF),
    scrimer = Color(0x40A8A8A8),
    calendarPeriod = Color(0x33515FE1),
    buttonSecondary = Color(Constants.LightColors.secondaryButton),
    textButton = Color(Constants.UniversalColors.textButton),
    black = Color(Constants.UniversalColors.black),
    gradient1 = listOf(Color(Constants.UniversalColors.gradient1_1), Color(Constants.UniversalColors.gradient1_2)),
    gradient2 = listOf(Color(Constants.UniversalColors.gradient2_1), Color(Constants.UniversalColors.gradient2_2)),
    gradient3 = listOf(Color(Constants.UniversalColors.gradient3_1), Color(Constants.UniversalColors.gradient3_2))
)

/**
 * [BankColors] instance for the dark theme
 */
val bankDarkColors = BankColors(
    bgPrimary = Color(Constants.DarkColors.bgPrimary),
    bgSecondary = Color(Constants.DarkColors.bgSecondary),
    contentPrimary = Color(Constants.DarkColors.contentPrimary),
    contentSecondary = Color(Constants.DarkColors.contentSecondary),
    contentTertiary = Color(Constants.DarkColors.contentTertiary),
    contentAccentPrimary = Color(Constants.DarkColors.contentAccentPrimary),
    contentAccentSecondary = Color(Constants.DarkColors.contentAccentSecondary),
    contentAccentTertiary = Color(Constants.DarkColors.contentAccentTertiary),
    textPrimary = Color(Constants.DarkColors.textPrimary),
    textSecondary = Color(Constants.DarkColors.textSecondary),
    textTertiary = Color(Constants.DarkColors.textTertiary),
    indicatorContendError = Color(Constants.DarkColors.indicatorContentError),
    indicatorContendDone = Color(Constants.DarkColors.indicatorContentDone),
    indicatorContendSuccess = Color(Constants.DarkColors.indicatorContentSuccess),
    primaryButton = Color(Constants.DarkColors.primaryButton),
    bgBottomMenu = Color(0x80353F3D),
    scrimer = Color(0x40000000),
    calendarPeriod = Color(0x336C78E6),
    buttonSecondary = Color(Constants.DarkColors.secondaryButton),
    textButton = Color(Constants.UniversalColors.textButton),
    black = Color(Constants.UniversalColors.black),
    gradient1 = listOf(Color(Constants.UniversalColors.gradient1_1), Color(Constants.UniversalColors.gradient1_2)),
    gradient2 = listOf(Color(Constants.UniversalColors.gradient2_1), Color(Constants.UniversalColors.gradient2_2)),
    gradient3 = listOf(Color(Constants.UniversalColors.gradient3_1), Color(Constants.UniversalColors.gradient3_2))
)
