package com.example.rxsample.ui.dagger2sample.module

import com.example.rxsample.common.dependency_class.Dchoose
import com.example.rxsample.data.SampleText
import dagger.Module
import dagger.Provides

@Module
class Dagger2Module {

    @Provides
    @Dchoose("primary")
    fun setSampleText() : SampleText {
        return SampleText("Hello Text 1", "Hello Text 2")
    }

    @Provides
    @Dchoose("secondary")
    fun setSampleText2() : SampleText {
        return SampleText("Hello Text 3", "Hello Text 4")
    }
}