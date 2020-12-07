package com.yogeshpaliyal.kmmsample.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

class BaseModel {
    @SerialName("title")
    var title = ""
    var message = ""
}