package com.hyeran.android.dodobo.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hyeran.android.dodobo.ApplicationController
import com.hyeran.android.dodobo.MainActivity
import com.hyeran.android.dodobo.Model.SignIn.SignInResponse
import com.hyeran.android.dodobo.Model.SignIn.SignInUser
import com.hyeran.android.dodobo.Network.NetworkService
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.Util.SharedPreference
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    // 통신
    lateinit var signInUser : SignInUser
    lateinit var networkService: NetworkService
    lateinit var token : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        networkService = ApplicationController.instance!!.networkService
        SharedPreference.instance!!.load(this)

        btn_signin_login.setOnClickListener {
            postSignIn()
        }
    }


    // 로그인  - 통신
    fun postSignIn(){

        signInUser = SignInUser(et_email_login.text.toString(), et_password_login.text.toString())

        val loginResponse = networkService.postSignIn(signInUser)

        loginResponse.enqueue(object : Callback<SignInResponse> {

            override fun onFailure(call: Call<SignInResponse>?, t: Throwable?) {
                Log.v("login 실패",t!!.message.toString())
                et_password_login.setBackgroundResource(R.drawable.login_textbox_error)
                //TODO: 로그인 실패 팝업 띄우기
            }

            override fun onResponse(call: Call<SignInResponse>?, response: Response<SignInResponse>?) {

                Log.e("dd ", "ddddd")

                if(response!!.isSuccessful){

                    et_password_login.setBackgroundResource(R.drawable.login_textbox)
                    Log.v("login 성공",response!!.body().message)
                    token = response!!.body()!!.result!!.token!!.toString()
                    Log.e("토큰: ", token)
                    SharedPreference.instance!!.setPrefData("token",token)
                    SharedPreference.instance!!.setPrefData("email",response!!.body()!!.result!!.profile.email)

                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()

                } else {
                    et_password_login.setBackgroundResource(R.drawable.login_textbox_error)
                }

            }

        })
    }
}
