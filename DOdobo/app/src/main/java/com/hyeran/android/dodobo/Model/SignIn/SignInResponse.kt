package com.hyeran.android.dodobo.Model.SignIn

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyeran.android.dodobo.Model.BaseModel


data class SignInResponse(

        @SerializedName("status")
        @Expose
        open var status : Int?=null,

        @SerializedName("message")
        @Expose
        open var message : String?=null,

        @SerializedName("result")
        @Expose
        open var result : SignInResult?=null

)


data class SignInResult(
        var profile: ProfileResult,
        var token: String
)

data class ProfileResult(
        var idx: Int,
        var email: String,
        var role: String
)

