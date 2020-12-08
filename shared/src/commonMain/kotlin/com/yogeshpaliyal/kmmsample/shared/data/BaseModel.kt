package com.yogeshpaliyal.kmmsample.shared.data

import kotlinx.serialization.SerialName

class BaseModel {
    @com.google.gson.annotations.SerializedName("title")
    var title = ""
    @com.google.gson.annotations.SerializedName("message")
    var message = ""
}