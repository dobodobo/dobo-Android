package com.hyeran.android.dodobo.mypage

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeran.android.dodobo.R
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*

class MypageTab : Fragment(), View.OnClickListener {

    lateinit var dobolistItems : ArrayList<DobolistItem>
    lateinit var dobolistAdapter : DobolistAdapter

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

        dobolistItems = ArrayList()
        dobolistItems.add(DobolistItem(R.drawable.home, "양재 시민의 숲(매헌)\n꽃 시장 탐방 코스"))
        dobolistItems.add(DobolistItem(R.drawable.home, "서울 나무 공방 탐험기!\n- 재질부터 완성까지 "))

        dobolistAdapter = DobolistAdapter(dobolistItems)
//        rv_dobolist_mypage.setHasFixedSize(true)
        rv_dobolist_mypage.layoutManager = LinearLayoutManager(activity)
        //TODO LinearLayoutManager() 안에 뭐 넣어야 하는지 모르겠음. 액티비티일 때 this로는 돌아가는데 프래그먼트일 때 안돌아감.
        (rv_dobolist_mypage.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_dobolist_mypage.adapter = dobolistAdapter
        return v
    }
}