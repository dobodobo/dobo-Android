package com.hyeran.android.dodobo

import android.app.Application
import com.hyeran.android.dodobo.Network.NetworkService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationController : Application(){
    lateinit var networkService: NetworkService
    private val baseUrl = "http://52.78.25.56:3000/api/"

    companion object {
        lateinit var instance : ApplicationController
    }

    override fun onCreate() {
        super.onCreate()
        instance = this // 어느 액티비티에서든지 '나'를 할당
        buildNetwork()
    }

    fun buildNetwork() {
        val builder = Retrofit.Builder()
        var retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) // GSON을 JSON으로 쓰기
                .build()    // baseUrl을 가지고 통신
        networkService = retrofit.create(NetworkService::class.java)
    }
}