package com.example.rxsample

import android.content.Intent
import android.os.Bundle
import com.example.rxsample.base.BaseActivity
import com.example.rxsample.ui.dagger2sample.Dagger2Activity
import com.example.rxsample.ui.rxsample.RxSampleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEvent()
    }

    private fun initEvent() {

        bt_rxsample.setOnClickListener {
            val intent = Intent(this, RxSampleActivity::class.java)
            startActivity(intent)
        }

        bt_dagger2.setOnClickListener {
            val intent = Intent(this, Dagger2Activity::class.java)
            startActivity(intent)
        }

    }

}
