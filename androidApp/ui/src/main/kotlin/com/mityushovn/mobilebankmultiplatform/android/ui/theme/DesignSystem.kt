package com.mityushovn.mobilebankmultiplatform.android.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

/**
 * Colors
 */
@Immutable
data class BankColors(
    val bgPrimary: Color,
    val bgSecondary: Color,
    val contentPrimary: Color,
    val contentSecondary: Color,
    val contentTertiary: Color,
    val contentAccentPrimary: Color,
    val contentAccentSecondary: Color,
    val contentAccentTertiary: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val indicatorContendError: Color,
    val indicatorContendDone: Color,
    val indicatorContendSuccess: Color,
    val primaryButton: Color,
    val bgBottomMenu: Color,
    val scrimer: Color,
    val calendarPeriod: Color,
    val buttonSecondary: Color,
    val textButton: Color,
    val black: Color,
    val gradient1: List<Color>,
    val gradient2: List<Color>,
    val gradient3: List<Color>
)

/**
 * Typography
 */
@Immutable
data class BankTypography(
    val largeTitle34: TextStyle,
    val title28: TextStyle,
    val subtitle_1_20_semibold: TextStyle,
    val body_20_regular: TextStyle,
    val subtitle_2_17_semibold: TextStyle,
    val body_1_17_regular: TextStyle,
    val body_15_semibold: TextStyle,
    val body_2_15_regular: TextStyle,
    val button: TextStyle,
    val caption_1_13_regular: TextStyle,
    val caption_2_11_regular: TextStyle
)