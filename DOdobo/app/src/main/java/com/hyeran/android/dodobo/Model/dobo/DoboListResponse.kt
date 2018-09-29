package com.hyeran.android.dodobo.Model.dobo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hyeran.android.dodobo.Model.BaseModel

data class DoboListResponse (
        @SerializedName("result")
        @Expose
        open var result : ArrayList<DoboListResult>
) : BaseModel()

data class DoboListResult (
        var idx : Int,
        var title : String,
        var intro : String,
        var image : String
)

