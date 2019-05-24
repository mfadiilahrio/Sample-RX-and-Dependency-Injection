package com.example.rxsample.ui.rxsample

import android.os.Bundle
import com.example.rxsample.R
import com.example.rxsample.base.BaseActivity
import com.example.rxsample.ui.rxsample.formvalidation_fragment.FormValidationFragment
import com.example.rxsample.ui.rxsample.rxsample_fragment.Listener
import com.example.rxsample.ui.rxsample.rxsample_fragment.RxSampleFragment
import kotlinx.android.synthetic.main.activity_rxsample.*

class RxSampleActivity : BaseActivity(), Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.title = getString(R.string.label_list_of_rx_sample)

        val rxSampleFragment = RxSampleFragment()

        rxSampleFragment.listener = this

        supportFragmentManager.beginTransaction()
            .add(android.R.id.content, rxSampleFragment)
            .addToBackStack(null)
            .commit()

    }

    override fun onFormValidationClicked() {
        val formValidationFragment = FormValidationFragment()

        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, formValidationFragment)
            .addToBackStack(null)
            .commit()
    }
}
