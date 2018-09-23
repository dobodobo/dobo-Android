package com.hyeran.android.dodobo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.hyeran.android.dodobo.dobo.DoboTab
import com.hyeran.android.dodobo.home.HomeTab
import com.hyeran.android.dodobo.home.Category
import com.hyeran.android.dodobo.mypage.MypageTab
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val bundle = Bundle()

    override fun onClick(v: View?) {
        when(v){
            btn_home_main -> {
                clearSelected()
                btn_home_main.isSelected = true
                btn_home_main.setImageResource(R.drawable.ic_home_p)
                replaceFragment(HomeTab())
            }
            btn_dobo_main -> {
                clearSelected()
                btn_dobo_main.isSelected = true
                btn_dobo_main.setImageResource(R.drawable.ic_dobo_p)
                replaceFragment(DoboTab())
            }
            btn_recommend_main -> {
                clearSelected()
                btn_recommend_main.isSelected = true
                btn_recommend_main.setImageResource(R.drawable.ic_recommend_p)
                replaceFragment(Category())
            }
            btn_mypage_main -> {
                clearSelected()
                btn_mypage_main.isSelected = true
                btn_mypage_main.setImageResource(R.drawable.ic_mypage_p)
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

        //TODO viewpager 추가
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
        btn_home_main.setImageResource(R.drawable.ic_home)
        btn_dobo_main.setImageResource(R.drawable.ic_dobo)
        btn_recommend_main.setImageResource(R.drawable.ic_recommend)
        btn_mypage_main.setImageResource(R.drawable.ic_mypage)
    }
}
