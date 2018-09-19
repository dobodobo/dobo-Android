package com.hyeran.android.dodobo.mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_apply_seoulight.*

class ApplySeoulightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_seoulight)
        btn_back_applyseoulight.setOnClickListener {
            finish()
        }
    }
}
