package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors.*
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.models.PhoneNumber
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

actual class PhoneNumberViewModel(
    private val repository: AuthRepository,
    private val backgroundDispatcher: CoroutineDispatcher
): ViewModel() {
    private val _uiState: MutableStateFlow<PhoneNumberUiState> = MutableStateFlow(PhoneNumberUiState())
    actual val uiState: StateFlow<PhoneNumberUiState> = _uiState.asStateFlow()

    fun buttonPressed() {
        with(_uiState) {
            value = value.copy(isLoading = true, isInvalidPhoneNumberError = false, isPhoneNumberNotRegisteredError = false)
        }

        viewModelScope.launch(backgroundDispatcher) {
            repository.getOptCode(PhoneNumber(_uiState.value.input))
                .fold(
                    { parseBankError(it) },
                    { println("successful, optcode is $it") }
                )
        }
    }

    fun inputChanged(input: String) {
        viewModelScope.launch {
            with(_uiState) {
                value = value.copy(input = input, isLoading = false, isInvalidPhoneNumberError = false, isPhoneNumberNotRegisteredError = false)
            }
        }
    }

    private fun parseBankError(e: BankError) {
        when(e) {
            is InvalidPhoneNumberError -> {
                with(_uiState) {
                    value = value.copy(isLoading = false, isInvalidPhoneNumberError = true, isPhoneNumberNotRegisteredError = false)
                }
            }
            is PhoneNumberIsNotRegistered -> {
                with(_uiState) {
                    value = value.copy(isLoading = false, isInvalidPhoneNumberError = false, isPhoneNumberNotRegisteredError = true)
                }
            }
            else -> {
                throw RuntimeException("Should be InvalidPhoneNumberError or PhoneNumberIsNotRegistered")
            }
        }
    }
}