package com.example.rxsample.ui.rxsample.formvalidation_fragment

import com.example.rxsample.common.TextInputValidation
import com.example.rxsample.common.ValidationResult
import com.example.rxsample.common.extension.alphabetAndSpace
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.subjects.PublishSubject

class FormValidationViewModelImpl : FormValidationViewModel, FormValidationViewModelInput,
    FormValidationViewModelOutput {

    override val inputs: FormValidationViewModelInput = this
    override val outputs: FormValidationViewModelOutput = this

    override val validateUsername: Observable<ValidationResult<TextInputValidation>>
    override val validateName: Observable<ValidationResult<TextInputValidation>>

    override val buttonEnabled: Observable<Boolean>

    private val mUsername = PublishSubject.create<String>()
    private val mName = PublishSubject.create<String>()

    init {
        validateUsername = mUsername.switchMap {
            when {
                it.isEmpty() -> Observable.just(ValidationResult.empty())
                !it.alphabetAndSpace -> Observable.just(ValidationResult.failed(TextInputValidation.INVALID_CHARACTERS))
                else -> Observable.just(ValidationResult.ok())
            }
        }

        validateName = mName.switchMap {
            when {
                it.isEmpty() -> Observable.just(ValidationResult.empty())
                it.length < 3 -> Observable.just(ValidationResult.failed(TextInputValidation.INVALID_LENGTH))
                else -> Observable.just(ValidationResult.ok())
            }
        }

        buttonEnabled = Observables.combineLatest(validateUsername, validateName) { username, name ->
            username.isValid && name.isValid
        }.distinctUntilChanged()
    }

    override fun username(username: String?) {
        mUsername.onNext(username ?: "")
    }

    override fun name(name: String?) {
        mName.onNext(name ?: "")
    }

}