package com.mityushovn.mobilebankmultiplatform.android.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.unit.dp

private const val Small = 4
private const val Medium = 2
private const val Large = 0


val bankShapes = Shapes(
    small = RoundedCornerShape(Small.dp),
    medium = RoundedCornerShape(Medium.dp),
    large = RoundedCornerShape(Large.dp)
)