package com.hyeran.android.dodobo.mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_apply_seoulight.*

class ApplySeoulightActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            btn_back_applyseoulight -> {
                finish()
            }
            iv_individual_applyseoulight -> {
                clearSelected()
                iv_individual_applyseoulight.isSelected = true
                iv_individual_applyseoulight.setImageResource(R.drawable.individualbtn_click)
            }
            iv_group_applyseoulight -> {
                clearSelected()
                iv_group_applyseoulight.isSelected = true
                iv_group_applyseoulight.setImageResource(R.drawable.group_click)
            }
            btn_complete_applyseoulight -> {
                val toastView = View.inflate(baseContext, R.layout.toast_complete_applyseoulight, null) as RelativeLayout
                val toastComplete = Toast(baseContext)

                toastComplete.view = toastView
                toastComplete.setGravity(Gravity.CENTER, 0, 0)  // 중앙으로 위치 이동(첫번째 인자를 중심으로 xOffset, yOffset 떨어진 곳)
                toastComplete.show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_seoulight)

        btn_back_applyseoulight.setOnClickListener(this)
        iv_individual_applyseoulight.setOnClickListener(this)
        iv_group_applyseoulight.setOnClickListener(this)
        btn_complete_applyseoulight.setOnClickListener(this)

    }

    fun clearSelected() {
        iv_individual_applyseoulight.isSelected = false
        iv_group_applyseoulight.isSelected = false
        iv_individual_applyseoulight.setImageResource(R.drawable.individualbtn_unclick)
        iv_group_applyseoulight.setImageResource(R.drawable.groupbtn_unclick)
    }
}
