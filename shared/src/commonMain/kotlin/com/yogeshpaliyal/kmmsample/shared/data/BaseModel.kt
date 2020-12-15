package com.yogeshpaliyal.kmmsample.shared.data

import kotlinx.serialization.SerialName

class BaseModel {
    @SerialName("title")
    var title = ""
    @SerialName("message")
    var message = ""
}