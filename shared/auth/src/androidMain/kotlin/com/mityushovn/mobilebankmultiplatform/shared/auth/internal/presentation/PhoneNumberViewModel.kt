package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.BankError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.InvalidPhoneNumberError
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.OtpCodeIsWrong
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.PhoneNumberIsNotRegistered
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.OtpCode
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.PhoneNumber
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.SmsCode
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

actual class PhoneNumberViewModel(
    private val repository: AuthRepository,
    private val backgroundDispatcher: CoroutineDispatcher
) : ViewModel() {
    private val _uiState: MutableStateFlow<PhoneNumberUiState> =
        MutableStateFlow(PhoneNumberUiState())
    actual val uiState: StateFlow<PhoneNumberUiState> = _uiState.asStateFlow()

    private var cachedOtpCode: OtpCode? = null

    fun buttonPressed() {
        showSearchFieldLoading()
        val state = "+${_uiState.value.input}"
        Log.d("ViewMOdel", "state is $state")

        viewModelScope.launch(backgroundDispatcher) {
            delay(2000)
            try {
                repository.getOtpCode(PhoneNumber(state))
                    .fold(
                        { parseBankError(it) },
                        {
                            Log.d("ViewMOdel", "successful, optcode is $it")
                            showModalSheet()
                            cachedOtpCode = it
                        }
                    )
            } catch (e: Exception) {
                showInvalidPhoneNumberError()
            } finally {
                hideSearchFieldLoading()
            }
        }
    }

    fun inputChanged(input: String) {
        val trimmed = trimInputPhone(input)
        showTrimmedInput(trimmed)
    }

    fun bottomSheetSwiped() {
        with(_uiState) {
            value = value.copy(isModalSheetVisible = false, optCodeTextFields = "")
        }
    }

    fun otpCodeChanged(optCode: String) {
        viewModelScope.launch(backgroundDispatcher) {
            val trimmed = trimOptCode(optCode)
            showTrimmedOtpCode(trimmed)

            if (optCode.length == 6) {
                sendOtpCodeAttempt(trimmed)
            }
        }
    }

    private fun showTrimmedInput(trimmed: String) {
        viewModelScope.launch {
            with(_uiState) {
                value = value.copy(
                    input = trimmed,
                    isSearchFieldLoading = false,
                    isInvalidPhoneNumberError = false,
                    isPhoneNumberNotRegisteredError = false,
                    optCodeTextFields = ""
                )
            }
        }
    }

    private fun showTrimmedOtpCode(trimmed: String) {
        with(_uiState) {
            value = value.copy(
                isSearchFieldLoading = false,
                isPhoneNumberNotRegisteredError = false,
                isInvalidPhoneNumberError = false,
                optCodeTextFields = trimmed
            )
        }
    }

    private fun parseBankError(e: BankError) {
        when (e) {
            is InvalidPhoneNumberError -> {
                showInvalidPhoneNumberError()
            }
            is PhoneNumberIsNotRegistered -> {
                showPhoneNumberIsNotRegisteredError()
            }
            is OtpCodeIsWrong -> {
                showOtpCodeError()
            }
            else -> {
                throw RuntimeException("Should be InvalidPhoneNumberError or PhoneNumberIsNotRegistered")
            }
        }
    }

    private fun showOtpSheetLoading() {
        with(_uiState) {
            value = value.copy(
                isOtpCodeWrong = false,
                isOtpSheetLoading = true
            )
        }
    }

    private fun showOtpCodeError() {
        with(_uiState) {
            value = value.copy(
                isOtpSheetLoading = false,
                isOtpCodeWrong = true
            )
        }
    }

    private fun showPhoneNumberIsNotRegisteredError() {
        with(_uiState) {
            value = value.copy(
                isSearchFieldLoading = false,
                isInvalidPhoneNumberError = false,
                isPhoneNumberNotRegisteredError = true
            )
        }
    }

    private fun showModalSheet() {
        with(_uiState) {
            value = value.copy(isModalSheetVisible = true)
        }
    }

    private fun showSearchFieldLoading() {
        with(_uiState) {
            value = value.copy(
                isSearchFieldLoading = true,
                isInvalidPhoneNumberError = false,
                isPhoneNumberNotRegisteredError = false,
                isModalSheetVisible = false
            )
        }
    }

    private fun showInvalidPhoneNumberError() {
        with(_uiState) {
            value = value.copy(
                isInvalidPhoneNumberError = true,
                isPhoneNumberNotRegisteredError = false,
                isModalSheetVisible = false
            )
        }
    }

    private fun hideSearchFieldLoading() {
        with(_uiState) {
            value = value.copy(isSearchFieldLoading = false)
        }
    }

    private fun sendOtpCodeAttempt(otpCode: String) {
        Log.d("ViewModel", "ViewModel, OtpCode attempts")
        viewModelScope.launch(backgroundDispatcher) {
            try {
                showOtpSheetLoading()
                delay(2000)
                repository.getGuestToken(
                    SmsCode(
                        PhoneNumber("+${_uiState.value.input}"),
                        cachedOtpCode!!
                    )
                )
                    .fold(
                        { parseBankError(it) },
                        { navigateToPasswordScreen() }
                    )
            } catch (e: Throwable) {
                showInvalidPhoneNumberError()
            } finally {
                hideOtpSheetLoading()
            }
        }
    }

    private fun hideOtpSheetLoading() {
        with(_uiState) {
            value = value.copy(
                isOtpSheetLoading = false
            )
        }
    }

    private fun navigateToPasswordScreen() {
        with(_uiState) {
            value = value.copy(
                navigateToPasswordScreen = true
            )
        }
    }

    private fun trimInputPhone(input: String): String =
        if (input.length > 11) input.substring(0..10) else input

    private fun trimOptCode(optCode: String): String =
        if (optCode.length > 6) optCode.substring(0..5) else optCode

}
