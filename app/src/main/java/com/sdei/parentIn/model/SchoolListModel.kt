package com.sdei.parentIn.model


import com.google.gson.annotations.SerializedName

data class SchoolListModel(
        @SerializedName("message")
        val message: String,
        @SerializedName("statusCode")
        val statusCode: Int,
        @SerializedName("data")
       val `data`: List<SchoolData>

)