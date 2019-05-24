package com.example.rxsample.ui.dagger2sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.example.rxsample.R
import com.example.rxsample.base.BaseActivity
import com.example.rxsample.common.dependency_class.Dclass1
import com.example.rxsample.common.dependency_class.Dclass2
import com.example.rxsample.common.dependency_class.Dhouse
import com.example.rxsample.component.DComponent
import com.example.rxsample.component.DaggerAppComponent
import com.example.rxsample.component.DaggerDComponent
import kotlinx.android.synthetic.main.activity_dagger2.*
import javax.inject.Inject

class Dagger2Activity : BaseActivity() {

    @Inject
    lateinit var dclass1: Dclass1

    @Inject
    lateinit var dclass2: Dclass2

    private var dComponent : DComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger2)
        DaggerAppComponent.create().inject(this)
        dComponent = DaggerDComponent.create()
        bt_submit.setOnClickListener {
            val dhouse = Dhouse()
            dComponent!!.inject(dhouse)
            val sample_text = "${dclass1.setText1()} || ${dclass2.setText2()} & {${dhouse.dnormal.totalCount} -- ${dhouse.dunique.totalCount}} "
            tv_test.text = sample_text
        }
    }

}
