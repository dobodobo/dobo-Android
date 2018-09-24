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
import com.hyeran.android.dodobo.Model.MyPage.FeedBackData
import com.hyeran.android.dodobo.Network.NetworkService
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.Util.SharedPreference
import kotlinx.android.synthetic.main.activity_suggestion.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SuggestionActivity : AppCompatActivity() {


    lateinit var networkService: NetworkService
    lateinit var feedBack: FeedBackData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suggestion)

        networkService = ApplicationController.instance!!.networkService
        SharedPreference.instance!!.load(this)

        btn_back_suggestion.setOnClickListener {
            finish()
        }
        btn_submit_suggestion.setOnClickListener {

            // 공백 체크
            if (et_title_suggestion.text.toString() == "" || et_content_suggestion.text.toString() == "") {
                //TODO : 디자인에 맞는 팝업 띄우기
                Toast.makeText(this, "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                postFeedBack()
            }
        }

    }

    // 마이 페이지 건의사항 - POST
    fun postFeedBack(){
         feedBack = FeedBackData(et_title_suggestion.text.toString()
                ,et_content_suggestion.text.toString())

        var suggestResponse = networkService.postFeedBack(
                SharedPreference.instance!!.getPrefStringData("token")!!,feedBack)

        suggestResponse.enqueue(object : Callback<BaseModel> {
            override fun onFailure(call: Call<BaseModel>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<BaseModel>?, response: Response<BaseModel>?) {
                if(response!!.isSuccessful){

                    val toastView = View.inflate(applicationContext, R.layout.toast_submit_suggestion, null) as RelativeLayout
                    val toastComplete = Toast(applicationContext)

                    toastComplete.view = toastView
                    toastComplete.setGravity(Gravity.CENTER, 0, 0)  // 중앙으로 위치 이동(첫번째 인자를 중심으로 xOffset, yOffset 떨어진 곳)
                    toastComplete.show()

                    Log.v("건의사항 성공",response!!.message())
                    finish()
                } else {
                    //TODO : 디자인에 맞는 팝업 띄우기
                    Log.e("건의사항 실패",response!!.message())

                }
            }

        })
    }
}
