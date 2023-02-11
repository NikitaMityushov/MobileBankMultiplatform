package com.mityushovn.mobilebankmultiplatform.android.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.sp
import com.mityushovn.mobilebankmultiplatform.android.ui.R

/**
 * Fonts
 */
private val SfProDisplayBold = FontFamily(Font(R.font.sf_pro_display_bold))
private val SfProDisplayMedium = FontFamily(Font(R.font.sf_pro_display_medium))
private val SfProDisplaySemibold = FontFamily(Font(R.font.sf_pro_display_semibold))
private val SfProDisplayRegular = FontFamily(Font(R.font.sf_pro_display_regular))
private val SfProTextSemibold = FontFamily(Font(R.font.sf_pro_text_semibold))
private val SfProTextRegular = FontFamily(Font(R.font.sf_pro_text_regular))

private val LargeTitle = TextStyle(
    fontFamily = SfProDisplayBold,
    fontSize = 34.sp,
    lineHeight = 41.sp
)

private val Title = TextStyle(
    fontFamily = SfProDisplayMedium,
    fontSize = 28.sp,
    lineHeight = 34.sp
)

private val Subtitle1Semibold = TextStyle(
    fontFamily = SfProDisplaySemibold,
    fontSize = 20.sp,
    lineHeight = 25.sp
)

private val BodyRegular = TextStyle(
    fontFamily = SfProDisplayRegular,
    fontSize = 20.sp,
    lineHeight = 25.sp
)

private val Subtitle2Semibold = TextStyle(
    fontFamily = SfProDisplaySemibold,
    fontSize = 17.sp,
    lineHeight = 22.sp
)

private val Body1_17Regular = TextStyle(
    fontFamily = SfProTextRegular,
    fontSize = 17.sp,
    lineHeight = 22.sp
)

private val Body1_15Semibold = TextStyle(
    fontFamily = SfProTextSemibold,
    fontSize = 15.sp,
    lineHeight = 20.sp
)

private val Body2_15Regular = TextStyle(
    fontFamily = SfProTextRegular,
    fontSize = 15.sp,
    lineHeight = 20.sp
)

private val Button = TextStyle(
    fontFamily = SfProTextSemibold,
    fontSize = 15.sp,
    lineHeight = 15.sp
)

private val Caption1_13Regular = TextStyle(
    fontFamily = SfProTextRegular,
    fontSize = 13.sp,
    lineHeight = 13.sp
)

private val Caption2_11Regular = TextStyle(
    fontFamily = SfProTextRegular,
    fontSize = 11.sp,
    lineHeight = 11.sp
)

/**
 * Typography instance for the project theme
 */
val bankTypography = BankTypography(
    largeTitle34 = LargeTitle,
    title28 = Title,
    subtitle_1_20_semibold = Subtitle1Semibold,
    body_20_regular = BodyRegular,
    subtitle_2_17_semibold = Subtitle2Semibold,
    body_1_17_regular = Body1_17Regular,
    body_15_semibold = Body1_15Semibold,
    body_2_15_regular = Body2_15Regular,
    button = Button,
    caption_1_13_regular = Caption1_13Regular,
    caption_2_11_regular = Caption2_11Regular
)