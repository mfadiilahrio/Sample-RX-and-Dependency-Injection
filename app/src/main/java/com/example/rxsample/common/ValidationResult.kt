package com.example.rxsample.common

sealed class ValidationResult<T> {
    val isValid: Boolean
        get() {
            return when(this) {
                ok<T>() -> true
                else -> false
            }
        }

    class Validating<T>: ValidationResult<T>()
    class Empty<T>: ValidationResult<T>()

    data class Ok<T>(val message: T?): ValidationResult<T>()
    data class Failed<T>(val message: T): ValidationResult<T>()

    companion object {
        fun <T> validating(): ValidationResult<T> =
            Validating()
        fun <T> empty(): ValidationResult<T> =
            Empty()
        fun <T> ok(): ValidationResult<T> =
            Ok(null)
        fun <T> ok(message: T): ValidationResult<T> =
            Ok(message)
        fun <T> failed(message: T): ValidationResult<T> =
            Failed(message)
    }
}