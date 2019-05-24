package com.example.rxsample.common.extension

val String.alphabetAndSpace: Boolean get() = this.contains("^[a-zA-Z\\s]+$".toRegex())
val String.validEmail: Boolean get() = this.contains("^[a-zA-Z0-9.!#\$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*\$".toRegex())
val String.validPassword: Boolean get() = this.contains("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}\$".toRegex())