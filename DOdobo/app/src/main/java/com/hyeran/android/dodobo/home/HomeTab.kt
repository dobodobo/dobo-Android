package com.hyeran.android.dodobo.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            btn_inform_dobo_home -> {
                val intent = Intent(context, InformDoboActivity::class.java)
                startActivity(intent)
            }
            btn_inform_seoulight_home -> {
                val intent = Intent(context, InformSeoulightActivity::class.java)
                startActivity(intent)
            }
        }
    }
    val bundle = Bundle()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        v.btn_inform_dobo_home.setOnClickListener(this)
        v.btn_inform_seoulight_home.setOnClickListener(this)
        return v
    }
}