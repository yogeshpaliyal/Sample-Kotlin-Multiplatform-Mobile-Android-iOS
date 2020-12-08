package com.yogeshpaliyal.kmmsample.shared.data



data class BaseApiModel (
    @com.google.gson.annotations.SerializedName("status")
    var status: Int = 0,

    @com.google.gson.annotations.SerializedName("message")
    var message: String = "",

    @com.google.gson.annotations.SerializedName("data")
    var data : com.google.gson.JsonElement? = null
)