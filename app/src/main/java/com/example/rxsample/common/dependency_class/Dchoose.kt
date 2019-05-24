package com.example.rxsample.common.dependency_class

import javax.inject.Qualifier

@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Dchoose (val value: String = "")