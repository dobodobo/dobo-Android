package com.hyeran.android.dodobo.mypage

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.hyeran.android.dodobo.ApplicationController
import com.hyeran.android.dodobo.Model.MyPage.MypageResponse
import com.hyeran.android.dodobo.Network.NetworkService
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.Util.SharedPreference
import com.hyeran.android.dodobo.recyclerview.mypagelist.DobolistAdapter
import com.hyeran.android.dodobo.recyclerview.mypagelist.DobolistItem
import kotlinx.android.synthetic.main.fragment_mypage.*
import kotlinx.android.synthetic.main.fragment_mypage.view.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MypageTab : Fragment(), View.OnClickListener {
    /*
    프래그먼트 리사이클러뷰 오류 해결 참고 링크
    https://stackoverflow.com/questions/48620115/kotlin-recyclerview-gave-me-null-pointer-exception
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 통신
        var networkService : NetworkService = ApplicationController.instance.networkService

        var getMypageResponse = networkService.getMypage(SharedPreference.instance!!.getPrefStringData("token")!!)
        getMypageResponse.enqueue(object  : retrofit2.Callback<MypageResponse> {
            override fun onResponse(call: Call<MypageResponse>?, response: Response<MypageResponse>?) {
                if(response!!.isSuccessful){
                    tv_name_mypage.text = response.body().result!!.nick
                    tv_email_mypage.text = response.body().result!!.email
                }
            }

            override fun onFailure(call: Call<MypageResponse>?, t: Throwable?) {

            }

        })

        dobolistItems = ArrayList()
        dobolistItems.add(DobolistItem(R.drawable.home, "양재 시민의 숲(매헌)\n꽃 시장 탐방 코스"))
        dobolistItems.add(DobolistItem(R.drawable.home, "서울 나무 공방 탐험기!\n- 재질부터 완성까지 "))


        var rv_applylist = view!!.findViewById<View>(R.id.rv_applylist_mypage) as RecyclerView
        dobolistAdapter = DobolistAdapter(dobolistItems, context!!)
        rv_applylist?.layoutManager = LinearLayoutManager(context!!)
        (rv_applylist.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_applylist?.adapter = dobolistAdapter

        var rv_openlist = view!!.findViewById<View>(R.id.rv_openlist_mypage) as RecyclerView
        dobolistAdapter = DobolistAdapter(dobolistItems, context!!)
        rv_openlist?.layoutManager = LinearLayoutManager(context!!)
        (rv_openlist.layoutManager as LinearLayoutManager).orientation = LinearLayoutManager.HORIZONTAL
        rv_openlist?.adapter = dobolistAdapter
    }

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


        return v

        //TODO 일반회원, 서울라이트 따라서 서울라이트 신청 버튼, 별표 아이콘, 개설 리스트 보이고 안보이고 설정
    }
}