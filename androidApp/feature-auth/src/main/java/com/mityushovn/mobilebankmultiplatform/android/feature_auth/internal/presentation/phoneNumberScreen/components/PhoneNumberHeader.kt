package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme

@Composable
fun PhoneNumberHeader(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(76.dp)
        )

        Image(
            imageVector = ImageVector.vectorResource(id = com.mityushovn.mobilebankmultiplatform.android.ui.R.drawable.logo_medium),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PhoneNumberHeaderPreview() {
    BankTheme {
        PhoneNumberHeader()
    }
}