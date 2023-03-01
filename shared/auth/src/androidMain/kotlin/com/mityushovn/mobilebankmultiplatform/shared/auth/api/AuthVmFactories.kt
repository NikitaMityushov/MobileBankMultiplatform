package com.mityushovn.mobilebankmultiplatform.shared.auth.api

import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.di.authDI
import com.mityushovn.mobilebankmultiplatform.shared.auth.internal.presentation.PhoneNumberVMFactory
import org.kodein.di.instance
import org.kodein.di.newInstance

object AuthVmFactories {
    val phoneNumberVMFactory by authDI.newInstance { PhoneNumberVMFactory(instance(), instance()) }
}