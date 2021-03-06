package com.example.rxsample.common.dependency_class

import com.example.rxsample.data.SampleText
import javax.inject.Inject

class Dclass2 @Inject constructor() {

    @Inject
    @field:Dchoose("primary")
    lateinit var sampleText1: SampleText

    @Inject
    @field:Dchoose("secondary")
    lateinit var sampleText2: SampleText

    fun setText2() : String {
        return "This is text from Dclass2 = [${sampleText1.text2()} && ${sampleText2.text2()}]"
    }

}