package com.hyeran.android.dodobo.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.android.dodobo.MainActivity
import com.hyeran.android.dodobo.NetworkService
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_signin_login.setOnClickListener {
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

            // 비밀번호 오류 시
            // et_password_login.setBackgroundResource(R.drawable.login_textbox_error)
        }
    }
}
