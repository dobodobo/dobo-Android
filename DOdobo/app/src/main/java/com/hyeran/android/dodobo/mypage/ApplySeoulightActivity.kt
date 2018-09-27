package com.hyeran.android.dodobo.mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.RelativeLayout
import android.widget.Toast
import com.hyeran.android.dodobo.ApplicationController
import com.hyeran.android.dodobo.Model.BaseModel
import com.hyeran.android.dodobo.Model.MyPage.SeoulightRegisterData
import com.hyeran.android.dodobo.Network.NetworkService
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.Util.SharedPreference
import kotlinx.android.synthetic.main.activity_apply_seoulight.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ApplySeoulightActivity : AppCompatActivity(), View.OnClickListener {

    // 통신
    lateinit var seoulightRegister: SeoulightRegisterData
    lateinit var networkService: NetworkService

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
                postSeoulightRegister()

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apply_seoulight)

        networkService = ApplicationController.instance!!.networkService
        SharedPreference.instance!!.load(this)

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

    fun postSeoulightRegister() {
        seoulightRegister = SeoulightRegisterData(et_name_seoulightregister.text.toString(), et_birth_seoulightregister.text.toString(),
                et_organization_seoulightregister.text.toString(), et_portpolio_seoulightregister.text.toString(),
                et_phone_seoulightregister.text.toString(), et_intro_seoulightregister.text.toString())

        var seoulightRegisterResponse = networkService.postSeoulightRegister(
                SharedPreference.instance!!.getPrefStringData("token")!!, seoulightRegister)

        seoulightRegisterResponse.enqueue(object : retrofit2.Callback<BaseModel> {
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                if(response!!.isSuccessful) {
                    Log.v("서울라이트 신청 성공", response!!.message())
                    val toastView = View.inflate(baseContext, R.layout.toast_complete_applyseoulight, null) as RelativeLayout
                    val toastComplete = Toast(baseContext)

                    toastComplete.view = toastView
                    toastComplete.setGravity(Gravity.CENTER, 0, 0)  // 중앙으로 위치 이동(첫번째 인자를 중심으로 xOffset, yOffset 떨어진 곳)
                    toastComplete.show()
                } else {
                    Log.e("서울라이트 신청 실패", response!!.message())

                }
            }

        })
    }
}
