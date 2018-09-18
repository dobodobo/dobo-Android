package com.hyeran.android.dodobo.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_inform_seoulight.*

class InformSeoulightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inform_seoulight)
        btn_back_informseoulight.setOnClickListener {
            finish()
        }
    }
}
