package com.mityushovn.mobilebankmultiplatform.android.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme

@Composable
fun ErrorSnackbar(
    modifier: Modifier = Modifier,
    message: String,
) {
    Snackbar(
        modifier = modifier,
        shape = RoundedCornerShape(13.dp),
        backgroundColor = BankTheme.colors.indicatorContendError,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = message,
            style = BankTheme.typography.caption_1_13_regular,
            color = BankTheme.colors.textButton,
        )
    }
}

@Composable
fun DefaultErrorSnackbar(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = { }
) {
        SnackbarHost(
            hostState = snackbarHostState,
            snackbar = { data ->
                    Snackbar(
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                        shape = RoundedCornerShape(13.dp),
                        backgroundColor = BankTheme.colors.indicatorContendError,
                        content = {
                            Text(
                                modifier = Modifier.padding(vertical = 10.dp),
                                text = data.message,
                                style = BankTheme.typography.caption_1_13_regular,
                                color = BankTheme.colors.textButton,
                            )
                        },
                    )
            },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Top)
        )

}

@Preview
@Composable
fun ErrorSnackBarPreview() {
    BankTheme {
        ErrorSnackbar(message = "No message!!!")
    }
}