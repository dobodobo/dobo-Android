package com.hyeran.android.dodobo.dobo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hyeran.android.dodobo.ApplicationController
import com.hyeran.android.dodobo.Model.dobo.DoboListData
import com.hyeran.android.dodobo.Model.dobo.DoboListResponse
import com.hyeran.android.dodobo.Model.dobo.DoboListResult
import com.hyeran.android.dodobo.Network.NetworkService
import com.hyeran.android.dodobo.R
import com.hyeran.android.dodobo.Util.SharedPreference
import com.hyeran.android.dodobo.recyclerview.dobolist.DobolistAdapter
import kotlinx.android.synthetic.main.fragment_dobo.*
import retrofit2.Call
import retrofit2.Response

class Dobolist : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        var intent = Intent(context, DoboDetailActivity::class.java)
        startActivity(intent)
    }

    lateinit var dobolistItems : ArrayList<DoboListResult>
    lateinit var dobolistAdapter : DobolistAdapter
    lateinit var doboList : DoboListData

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 통신

//        var getMypageResponse = networkService.getMypage(SharedPreference.instance!!.getPrefStringData("token")!!)
//        getMypageResponse.enqueue(object  : retrofit2.Callback<MypageResponse> {
//            override fun onResponse(call: Call<MypageResponse>?, response: Response<MypageResponse>?) {
//                if(response!!.isSuccessful){
//                    tv_name_mypage.text = response.body().result!!.nick
//                    tv_email_mypage.text = response.body().result!!.email
//                    role = response.body().result!!.role
//                    if(role == "SEOULITE") {   // 서울라이트일 때
//                        icon_seoulight_modify.visibility = View.VISIBLE
//                        btn_applyseoulight_mypage.visibility = View.INVISIBLE
//                        tv_openlist_mypage.visibility = View.VISIBLE
//                        rv_openlist_mypage.visibility = View.VISIBLE
//                    } else {
//                        icon_seoulight_modify.visibility = View.INVISIBLE
//                        btn_applyseoulight_mypage.visibility = View.VISIBLE
//                        tv_openlist_mypage.visibility = View.INVISIBLE
//                        rv_openlist_mypage.visibility = View.INVISIBLE
//                    }
//                }
//            }
//
//            override fun onFailure(call: Call<MypageResponse>?, t: Throwable?) {
//
//            }
//
//
//        })
//
//        dobolistItems = ArrayList()
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))
//        dobolistItems.add(DobolistItem(R.drawable.home, "여기는 타이틀", "여기는 설명!!_!_!_!_!_!_!__!_!_!_!_!_!_!_!_!_"))

//        var rv_dobolist = view!!.findViewById<View>(R.id.rv_dobolist_dobo) as RecyclerView
//        dobolistAdapter = DobolistAdapter(dobolistItems, context!!)
//        dobolistAdapter.setOnItemClickListener(this)
//        rv_dobolist?.layoutManager = LinearLayoutManager(context!!)
//        rv_dobolist?.adapter = dobolistAdapter

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dobo, container, false)
        network()
    }

    fun network() {
        var networkService : NetworkService = ApplicationController.instance.networkService
        var requestManager : RequestManager = Glide.with(this)

        var category = activity!!.intent.getIntExtra("category", 0)


        rv_dobolist_dobo.layoutManager = LinearLayoutManager(context)

        var getDoboListResponse = networkService.getDoboList(SharedPreference.instance!!.getPrefStringData("token")!!, 0)
        getDoboListResponse.enqueue(object : retrofit2.Callback<DoboListResponse> {
            override fun onFailure(call: Call<DoboListResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<DoboListResponse>?, response: Response<DoboListResponse>?) {
                if(response!!.isSuccessful) {
                    Toast.makeText(context, "어디서 잘못되는 걸까?", Toast.LENGTH_SHORT).show()
//                dobolistAdapter.setOnItemClickListener(this)
                    dobolistItems = response.body().result
//                    rv_dobolist?.layoutManager = LinearLayoutManager(context!!)
//                    rv_dobolist?.adapter = dobolistAdapter
//
//                    var rv_seoulightlist = view!!.findViewById<View>(R.id.rv_seoulightlist_recommend) as RecyclerView
//                    seoulightlistAdapter = SeoulightlistAdapter(seoulightlistItems, context!!)
//                    seoulightlistAdapter.setOnItemClickListener(this)
//                    rv_seoulightlist?.layoutManager = LinearLayoutManager(context!!)
//                    rv_seoulightlist?.adapter = seoulightlistAdapter
                } else{
                    Log.e("도보 리스트 로드", response!!.message())

                }

            }

        })
        dobolistAdapter = DobolistAdapter(dobolistItems, context!!)
        rv_dobolist_dobo.adapter = dobolistAdapter

    }


}