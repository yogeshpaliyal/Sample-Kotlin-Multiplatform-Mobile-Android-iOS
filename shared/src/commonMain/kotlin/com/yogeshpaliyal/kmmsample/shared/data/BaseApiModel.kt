package com.yogeshpaliyal.kmmsample.shared.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

data class BaseApiModel (
    @SerialName("status")
    var status: Int = 0,

    @SerialName("message")
    var message: String = "",

    @SerialName("data")
    var data : JsonElement? = null
)