package com.hyeran.android.dodobo.Network

import com.hyeran.android.dodobo.Model.SignIn.SignInResponse
import com.hyeran.android.dodobo.Model.SignIn.SignInUser
import com.hyeran.android.dodobo.Model.SignUp.SignUpUser
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    // 로그인 - POST
    @POST("users/signin")
    fun postSignIn(
            @Body signInUser: SignInUser
    ) : Call<SignInResponse>

}