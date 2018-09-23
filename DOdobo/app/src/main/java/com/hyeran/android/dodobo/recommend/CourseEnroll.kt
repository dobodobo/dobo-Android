package com.hyeran.android.dodobo.recommend

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_course_enroll.*

class CourseEnroll : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            btn_culture_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_culture_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_culture_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_history_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_history_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_history_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_festival_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_festival_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_festival_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_food_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_food_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_food_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_activity_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_activity_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_activity_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_etc_courseenroll -> {
                selected(v)
                if(v!!.isSelected)
                    btn_etc_courseenroll.setTextColor(Color.parseColor("#79c8c6"))
                else
                    btn_etc_courseenroll.setTextColor(Color.parseColor("#9b9b9b"))
            }
            btn_back_courseenroll -> {
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_enroll)

        btn_back_courseenroll.setOnClickListener(this)
        btn_culture_courseenroll.setOnClickListener(this)
        btn_history_courseenroll.setOnClickListener(this)
        btn_festival_courseenroll.setOnClickListener(this)
        btn_food_courseenroll.setOnClickListener(this)
        btn_activity_courseenroll.setOnClickListener(this)
        btn_etc_courseenroll.setOnClickListener(this)
    }

    fun selected(v: View?) {
        if(!v!!.isSelected) {
            v!!.isSelected = true
            v!!.setBackgroundResource(R.drawable.rectangle_7)
        } else {
            v!!.isSelected = false
            v!!.setBackgroundResource(R.drawable.rectangle_7_copy)
        }
    }
}
