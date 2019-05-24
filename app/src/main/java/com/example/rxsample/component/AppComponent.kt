package com.example.rxsample.component

import com.example.rxsample.ui.dagger2sample.Dagger2Activity
import com.example.rxsample.ui.dagger2sample.module.Dagger2Module
import dagger.Component

@Component(modules = [
    Dagger2Module::class
])
interface AppComponent {
    fun inject(context: Dagger2Activity)
}