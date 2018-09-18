package com.hyeran.android.dodobo.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_inform_dobo.*

class InformDoboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inform_dobo)
        btn_back_informdobo.setOnClickListener {
            finish()
        }
    }
}
