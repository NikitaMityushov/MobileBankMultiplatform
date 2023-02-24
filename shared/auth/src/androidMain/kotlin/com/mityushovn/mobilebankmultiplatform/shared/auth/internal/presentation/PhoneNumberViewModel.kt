package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation

import androidx.lifecycle.ViewModel
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.repositories.AuthRepository

actual class PhoneNumberViewModel(
    private val repository: AuthRepository
): ViewModel()