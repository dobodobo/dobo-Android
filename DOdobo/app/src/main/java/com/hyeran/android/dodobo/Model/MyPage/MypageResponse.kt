package com.hyeran.android.dodobo.Model.MyPage

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyeran.android.dodobo.Model.BaseModel

data class MypageResponse (
    @SerializedName("result")
    @Expose
    open var result : MypageResult?=null
) : BaseModel()

data class MypageResult(
        var email : String,
        var nick : String
)