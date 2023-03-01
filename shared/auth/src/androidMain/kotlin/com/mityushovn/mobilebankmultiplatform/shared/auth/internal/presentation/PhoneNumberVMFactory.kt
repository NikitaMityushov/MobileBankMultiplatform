package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher

class PhoneNumberVMFactory(
    private val repository: AuthRepository,
    private val backgroundDispatcher: CoroutineDispatcher
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhoneNumberViewModel::class.java)) {
            return PhoneNumberViewModel(repository, backgroundDispatcher) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}