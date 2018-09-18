package com.hyeran.android.dodobo.mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_suggestion.*

class SuggestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestion)
        btn_back_suggestion.setOnClickListener {
            finish()
        }
    }
}
