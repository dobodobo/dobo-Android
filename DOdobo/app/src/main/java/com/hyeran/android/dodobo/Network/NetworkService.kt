package com.hyeran.android.dodobo.Network

import com.hyeran.android.dodobo.Model.BaseModel
import com.hyeran.android.dodobo.Model.MyPage.FeedBackData
import com.hyeran.android.dodobo.Model.MyPage.MypageResponse
import com.hyeran.android.dodobo.Model.MyPage.PasswordData
import com.hyeran.android.dodobo.Model.MyPage.SeoulightRegisterData
import com.hyeran.android.dodobo.Model.SignIn.SignInResponse
import com.hyeran.android.dodobo.Model.SignIn.SignInUser
import com.hyeran.android.dodobo.Model.SignUp.SignUpUser
import com.hyeran.android.dodobo.Model.dobo.DoboListResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    // 회원가입 - POST (avatarX)
    @POST("users/signup")
    fun postSignUp(
            @Body signUpUser: SignUpUser
    ): Call<BaseModel>

    // =============================================== 로그인 - POST
    @POST("users/signin")
    fun postSignIn(
            @Body signInUser: SignInUser
    ): Call<SignInResponse>

    // =============================================== 비밀번호 수정 - PUT
    @PUT("users/pwd")
    fun putPassword(
            @Header("token") token: String,
            @Body passwordData: PasswordData
    ): Call<BaseModel>

    // 프로필 사진 수정 - PUT (X) internal sever error
    @PUT("users/avatar")
    fun putProfileImage(
            @Header("token") token: String,
            @Body profileImg: MultipartBody.Part?
    ): Call<BaseModel>

    // =============================================== 건의사항 - POST
    @POST("users/feedback")
    fun postFeedBack(
            @Header("token") token: String,
            @Body feedBackData: FeedBackData
    ): Call<BaseModel>

    // =============================================== 시민해설사 신청 - POST
    @POST("seoulight/register")
    fun postSeoulightRegister(
            @Header("token") token: String,
            @Body seoulightRegisterData: SeoulightRegisterData
    ): Call<BaseModel>

    // 마이페이지 - GET (△)
    @GET("users/mypage")
    fun getMypage(
            @Header("token") token: String
    ): Call<MypageResponse>
}
