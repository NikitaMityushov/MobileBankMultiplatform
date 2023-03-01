package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberFragment

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme
import com.mityushovn.mobilebankmultiplatform.shared.auth.api.AuthVmFactories
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberViewModel

@Composable
fun PhoneNumberScreen(
    viewModel: PhoneNumberViewModel,
    modifier: Modifier = Modifier
) {
    Column {
        Icon(painter = painterResource(id = com.mityushovn.mobilebankmultiplatform.android.ui.R.mipmap.digital_bank), contentDescription = "")

        Spacer(modifier = Modifier)

        Button(onClick = { /*TODO*/ }) {
            Text(text = "button")
        }
    }

}

@Preview(
    name = "PhoneNumberScreenPreview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun PhoneNumberScreenPreview() {
    val viewModel: PhoneNumberViewModel = viewModel(factory = AuthVmFactories.phoneNumberVMFactory)
    BankTheme {
        PhoneNumberScreen(viewModel)
    }
}