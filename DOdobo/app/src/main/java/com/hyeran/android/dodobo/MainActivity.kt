package com.hyeran.android.dodobo

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.hyeran.android.dodobo.home.HomeTab
import com.hyeran.android.dodobo.mypage.MypageTab
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val bundle = Bundle()

    override fun onClick(v: View?) {
        when(v){
            btn_home_main -> {
                clearSelected()
                btn_home_main.isSelected = true
                icon_home_main.setColorFilter(Color.parseColor("#79C8C6"))
                tv_home_main.setTextColor(Color.parseColor("#79C8C6"))
                replaceFragment(HomeTab())
            }
            btn_dobo_main -> {
                clearSelected()
                btn_dobo_main.isSelected = true
                icon_dobo_main.setColorFilter(Color.parseColor("#79C8C6"))
                tv_dobo_main.setTextColor(Color.parseColor("#79C8C6"))
                replaceFragment(DoboTab())
            }
            btn_recommend_main -> {
                clearSelected()
                btn_recommend_main.isSelected = true
                icon_recommend_main.setColorFilter(Color.parseColor("#79C8C6"))
                tv_recommend_main.setTextColor(Color.parseColor("#79C8C6"))
                replaceFragment(RecommendTab())
            }
            btn_mypage_main -> {
                clearSelected()
                btn_mypage_main.isSelected = true
                icon_mypage_main.setColorFilter(Color.parseColor("#79C8C6"))
                tv_mypage_main.setTextColor(Color.parseColor("#79C8C6"))
                replaceFragment(MypageTab())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragment(HomeTab())
        btn_home_main.isSelected = true
        btn_home_main.setOnClickListener(this)
        btn_dobo_main.setOnClickListener(this)
        btn_recommend_main.setOnClickListener(this)
        btn_mypage_main.setOnClickListener(this)
    }

    fun addFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.add(R.id.frame_main, fragment)
        transaction.commit()
    }

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        fragment.arguments = bundle
        transaction.replace(R.id.frame_main, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun clearSelected() {
        btn_home_main.isSelected = false
        btn_dobo_main.isSelected = false
        btn_recommend_main.isSelected = false
        btn_mypage_main.isSelected = false
        icon_home_main.setColorFilter(Color.parseColor("#D1D3D4"))
        icon_dobo_main.setColorFilter(Color.parseColor("#D1D3D4"))
        icon_recommend_main.setColorFilter(Color.parseColor("#D1D3D4"))
        icon_mypage_main.setColorFilter(Color.parseColor("#D1D3D4"))
        tv_home_main.setTextColor(Color.parseColor("#89000000"))
        tv_dobo_main.setTextColor(Color.parseColor("#89000000"))
        tv_recommend_main.setTextColor(Color.parseColor("#89000000"))
        tv_mypage_main.setTextColor(Color.parseColor("#89000000"))

    }
}
