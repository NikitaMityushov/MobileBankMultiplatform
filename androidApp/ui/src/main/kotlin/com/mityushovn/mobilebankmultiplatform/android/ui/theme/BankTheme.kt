package com.mityushovn.mobilebankmultiplatform.android.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

private val LocalBankColors = staticCompositionLocalOf {
    BankColors(
        bgPrimary = Color.Unspecified,
        bgSecondary = Color.Unspecified,
        contentPrimary = Color.Unspecified,
        contentSecondary = Color.Unspecified,
        contentTertiary = Color.Unspecified,
        contentAccentPrimary = Color.Unspecified,
        contentAccentSecondary = Color.Unspecified,
        contentAccentTertiary = Color.Unspecified,
        textPrimary = Color.Unspecified,
        textSecondary = Color.Unspecified,
        textTertiary = Color.Unspecified,
        indicatorContendError = Color.Unspecified,
        indicatorContendDone = Color.Unspecified,
        indicatorContendSuccess = Color.Unspecified,
        primaryButton = Color.Unspecified,
        bgBottomMenu = Color.Unspecified,
        scrimer = Color.Unspecified,
        calendarPeriod = Color.Unspecified,
        buttonSecondary = Color.Unspecified,
        textButton = Color.Unspecified,
        black = Color.Unspecified,
        gradient1 = listOf(Color.Unspecified, Color.Unspecified),
        gradient2 = listOf(Color.Unspecified, Color.Unspecified),
        gradient3 = listOf(Color.Unspecified, Color.Unspecified)
    )
}

private val LocalBankTypography = staticCompositionLocalOf {
    BankTypography(
        largeTitle34 = TextStyle.Default,
        title28 = TextStyle.Default,
        subtitle_1_20_semibold = TextStyle.Default,
        body_20_regular = TextStyle.Default,
        subtitle_2_17_semibold = TextStyle.Default,
        body_1_17_regular = TextStyle.Default,
        body_15_semibold = TextStyle.Default,
        body_2_15_regular = TextStyle.Default,
        button = TextStyle.Default,
        caption_1_13_regular = TextStyle.Default,
        caption_2_11_regular = TextStyle.Default
    )
}
