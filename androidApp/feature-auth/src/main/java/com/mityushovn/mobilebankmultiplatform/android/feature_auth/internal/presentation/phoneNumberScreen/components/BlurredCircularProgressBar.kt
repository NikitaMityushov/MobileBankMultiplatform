package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme

@Composable
fun BlurredCircularProgressBar(
    modifier: Modifier = Modifier,
    scrimerColor: Color,
    circularIndicatorColor: Color
) {
    val brush = Brush.verticalGradient(
        0f to scrimerColor,
        0.4f to scrimerColor
    )

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        // Draw the blurred background with a Canvas composable
        Canvas(modifier = Modifier.fillMaxSize().blur(16.dp)) {
            drawRect(
                brush = brush,
                topLeft = Offset(0f, 0f),
                size = size
            )
        }
        // Add the circular progress indicator on top of the blurred background
        CircularProgressIndicator(
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.Center),
            color = circularIndicatorColor,
            strokeWidth = 2.dp
        )
    }
}

@Preview
@Composable
fun BlurredCircularProgressBarPreview() {
    BankTheme {
        BlurredCircularProgressBar(
            scrimerColor = BankTheme.colors.scrimer,
            circularIndicatorColor = BankTheme.colors.contentAccentPrimary
        )
    }
}