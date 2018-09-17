package com.hyeran.android.dodobo.mypage

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*

class MypageTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            btn_modify_mypage -> {
                val intent = Intent(context, ModifyActivity::class.java)
                startActivity(intent)
            }
            btn_applyseoulight_mypage -> {
                val intent = Intent(context, ApplySeoulightActivity::class.java)
                startActivity(intent)
            }
            btn_suggestion_mypage -> {
                val intent = Intent(context, SuggestionActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypage, container, false)
        v.btn_modify_mypage.setOnClickListener(this)
        v.btn_applyseoulight_mypage.setOnClickListener(this)
        v.btn_suggestion_mypage.setOnClickListener(this)
        return v
    }
}