package com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.R
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components.BlurredCircularProgressBar
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components.PhoneNumberBody
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components.PhoneNumberBottomSheet
import com.mityushovn.mobilebankmultiplatform.android.feature_auth.internal.presentation.phoneNumberScreen.components.PhoneNumberHeader
import com.mityushovn.mobilebankmultiplatform.android.ui.components.DefaultErrorSnackbar
import com.mityushovn.mobilebankmultiplatform.android.ui.theme.BankTheme
import com.mityushovn.mobilebankmultiplatform.shared.auth.api.AuthVmFactories
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PhoneNumberScreen(
    viewModel: PhoneNumberViewModel,
    modifier: Modifier = Modifier
) {
    val uiState = viewModel.uiState.collectAsState()
    val focusManager = LocalFocusManager.current
    val scaffoldState = rememberScaffoldState()

    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = true
    )

    Box(modifier = modifier) {
        ModalBottomSheetLayout(
            sheetContent = {
                Box {
                    PhoneNumberBottomSheet(
                        uiState = uiState.value,
                        onValueChanged = { viewModel.otpCodeChanged(it) })
                }
            },
            sheetShape = RoundedCornerShape(12.dp),
            sheetState = modalBottomSheetState,
            sheetBackgroundColor = BankTheme.colors.textButton,
            scrimColor = BankTheme.colors.scrimer
        ) {
            Scaffold(
                modifier = if (modalBottomSheetState.isVisible) Modifier.blur(16.dp) else Modifier,
                scaffoldState = scaffoldState,
                snackbarHost = { hostState ->
                    DefaultErrorSnackbar(snackbarHostState = hostState)
                },
            ) {
                if (!modalBottomSheetState.isVisible) {
                    LaunchedEffect(Unit) {
                        coroutineScope.launch {
                            viewModel.bottomSheetSwiped()
                        }
                    }
                }

                if (uiState.value.isInvalidPhoneNumberError) {
                    val message = stringResource(id = R.string.invalid_number)
                    LaunchedEffect(Unit) {
                        coroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                message = message
                            )
                        }
                    }
                }

                if (uiState.value.isModalSheetVisible) {
                    LaunchedEffect(Unit) {
                        coroutineScope.launch {
                            modalBottomSheetState.show()
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(it)
                        .background(
                            color = BankTheme.colors.bgPrimary
                        )
                        .padding(start = 16.dp, end = 16.dp, bottom = 24.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(onTap = {
                                focusManager.clearFocus()
                            })
                        },
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    PhoneNumberHeader(modifier = Modifier.fillMaxWidth())
                    PhoneNumberBody(
                        viewModel = viewModel,
                        uiState = uiState,
                        modifier = Modifier.fillMaxWidth(),
                        focusManager = focusManager
                    )
                }
            }
        }

        if (uiState.value.isOtpSheetLoading) {
            focusManager.clearFocus()
            BlurredCircularProgressBar(
                modifier = Modifier.fillMaxSize(),
                scrimerColor = BankTheme.colors.scrimer,
                circularIndicatorColor = BankTheme.colors.contentAccentPrimary
            )
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
        PhoneNumberScreen(
            viewModel,
            Modifier
                .fillMaxSize()
                .background(
                    color = BankTheme.colors.bgPrimary
                )
        )
    }
}