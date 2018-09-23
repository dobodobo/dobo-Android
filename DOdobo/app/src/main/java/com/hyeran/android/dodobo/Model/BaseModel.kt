package com.hyeran.android.dodobo.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class BaseModel(
        @SerializedName("status")
        @Expose
        open var status : Int?=null,

        @SerializedName("description")
        @Expose
        open var description : String?=null,

        @SerializedName("message")
        @Expose
        open var message : String?=null


)