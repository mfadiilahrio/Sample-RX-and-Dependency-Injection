package com.example.rxsample.ui.rxsample.rxsample_fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.rxsample.R
import kotlinx.android.synthetic.main.fragment_rx_sample_fragemnt.view.*

interface Listener {
    fun onFormValidationClicked()
}

class RxSampleFragment : Fragment() {

    var listener:  Listener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_rx_sample_fragemnt, container, false)

        view.bt_form_validation.setOnClickListener {
            listener?.onFormValidationClicked()
        }

        return view
    }

}
