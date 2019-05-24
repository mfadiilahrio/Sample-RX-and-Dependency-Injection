package com.example.rxsample.component

import com.example.rxsample.common.dependency_class.Dhouse
import com.example.rxsample.common.dependency_class.Dscope
import com.example.rxsample.ui.dagger2sample.module.DcountModule
import dagger.Component

@Dscope
@Component(modules = [
    DcountModule::class
])
interface DComponent {
    fun inject(dhouse: Dhouse)
}