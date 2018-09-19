package com.hyeran.android.dodobo.mypage

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_modify.*
import android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
import android.text.InputType.TYPE_CLASS_TEXT



class ModifyActivity : AppCompatActivity(), View.OnClickListener {



    override fun onClick(v: View?) {
        when(v) {
            btn_back_modify -> {
                finish()
            }
            btn_show1_modify -> {
                et_password1_modify.inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
            btn_show2_modify -> {
                et_password2_modify.inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
            btn_applyseoulight_modify -> {
                val intent = Intent(applicationContext, ApplySeoulightActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify)
        btn_back_modify.setOnClickListener(this)
        btn_show1_modify.setOnClickListener(this)
        btn_show2_modify.setOnClickListener(this)
        btn_applyseoulight_modify.setOnClickListener(this)
    }
}
