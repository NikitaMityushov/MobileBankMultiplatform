package com.mityushovn.mobilebankmultiplatform.shared.auth.internal.domain.errors

sealed interface BankError

object NetworkError: BankError
object UnknownError: BankError
object ParseError: BankError
object InvalidPhoneNumberError: BankError
object PhoneNumberIsNotRegistered: BankError
object ShortCodesAreNotTheSame: BankError
object PasswordsAreNotTheSame: BankError
object PinCodeIsNotValid: BankError
object PasswordIsNotValid: BankError
