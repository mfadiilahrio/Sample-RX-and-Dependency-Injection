package com.example.rxsample.ui.dagger2sample.module

import com.example.rxsample.common.dependency_class.Dscope
import com.example.rxsample.common.dependency_class.Dnormal
import com.example.rxsample.common.dependency_class.Dunique
import dagger.Module
import dagger.Provides

@Module
class DcountModule {

    private var count = 5

    @Dscope
    @Provides
    fun uniqCount() : Dunique {
        return Dunique(count++)
    }

    @Provides
    fun normalCount() : Dnormal {
        return Dnormal(count++)
    }
}