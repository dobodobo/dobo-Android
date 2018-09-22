package com.hyeran.android.dodobo.mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_suggestion.*

class SuggestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestion)
        btn_back_suggestion.setOnClickListener {
            finish()
        }
        btn_submit_suggestion.setOnClickListener {
            val toastView = View.inflate(applicationContext, R.layout.toast_submit_suggestion, null) as RelativeLayout
            val toastComplete = Toast(applicationContext)

            toastComplete.view = toastView
            toastComplete.setGravity(Gravity.CENTER, 0, 0)  // 중앙으로 위치 이동(첫번째 인자를 중심으로 xOffset, yOffset 떨어진 곳)
            toastComplete.show()
        }

    }
}
