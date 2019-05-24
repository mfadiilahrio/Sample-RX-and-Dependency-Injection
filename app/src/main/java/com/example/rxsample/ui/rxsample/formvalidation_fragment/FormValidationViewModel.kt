package com.example.rxsample.ui.rxsample.formvalidation_fragment

import com.example.rxsample.common.TextInputValidation
import com.example.rxsample.common.ValidationResult
import io.reactivex.Observable

interface FormValidationViewModelInput {
    fun username(username : String?)
    fun name(name : String?)
}

interface FormValidationViewModelOutput {
    val validateUsername: Observable<ValidationResult<TextInputValidation>>
    val validateName: Observable<ValidationResult<TextInputValidation>>

    val buttonEnabled: Observable<Boolean>
}

interface FormValidationViewModel {
    val inputs : FormValidationViewModelInput
    val outputs : FormValidationViewModelOutput
}
