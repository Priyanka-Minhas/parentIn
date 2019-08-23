package com.sdei.parentIn.model


import com.google.gson.annotations.SerializedName

data class SchoolData(
    @SerializedName("address")
    val address: String,
    @SerializedName("code")
    val code: String,
    @SerializedName("department")
    val department: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("notes")
    val notes: String,
    @SerializedName("schoolName")
    val schoolName: String,
    @SerializedName("suggestedAddress")
    val suggestedAddress: String,
    @SerializedName("__v")
    val v: Int
)