package com.example.rxsample.ui.rxsample.formvalidation_fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import com.example.rxsample.R
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_form_validation.view.*
import java.util.*

class FormValidationFragment : Fragment(){

    lateinit var viewModel: FormValidationViewModel
    private val disposable = CompositeDisposable()

    lateinit var mSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.viewModel = FormValidationViewModelImpl()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form_validation, container, false)

        mSubmit = view.bt_submit

        view.et_username.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                viewModel.inputs.username(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        view.et_name.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                viewModel.inputs.name(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        disposable.add(viewModel.outputs.validateUsername.subscribe({}, ::error))
        disposable.add(viewModel.outputs.validateName.subscribe({}, ::error))
        disposable.add(viewModel.outputs.buttonEnabled.subscribe(::toggleButton ,::error))

        mSubmit.isEnabled = false

        return view
    }

    private fun toggleButton(isEnabled: Boolean) {
        mSubmit.isEnabled = isEnabled
    }

}
