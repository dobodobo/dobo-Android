package com.hyeran.android.dodobo.home

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.activity_inform_dobo.*

class InformDoboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inform_dobo)
        btn_back_informdobo.setOnClickListener {
            finish()
        }
        // 도보관광 자세히보기 홈페이지 링크
        btn_link_informdobo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://korean.visitseoul.net/walkingtour/%EB%8F%84%EB%B3%B4%EA%B4%80%EA%B4%91%EC%9D%B4%EB%9E%80_/15020"))
            startActivity(intent)
        }
    }
}
