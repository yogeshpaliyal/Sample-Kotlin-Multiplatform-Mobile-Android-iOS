package com.yogeshpaliyal.kmmsample.shared

import com.yogeshpaliyal.kmmsample.shared.data.BaseApiModel

open class BaseCaller {
    private val params by lazy {
        HashMap<String, String>()
    }

    suspend fun apiCall(api: String): Resource<BaseApiModel> {
            val httpClient = HttpClient {

        }

        val respone = httpClient.request<HttpResponse> {
            url(api)
            method = HttpMethod.Post
            /* body = MultiPartFormDataContent(
                 formData {
                     for (param in params) {
                         append(param.key,param.value)
                     }
                 }
             )*/
            /*body = TextContent(
                text = "{"\"token\":\"gxdvaLqgxrxbcXCxrnDqcQ\"}"

            )*/
        }


        if (respone.status == HttpStatusCode.OK) {
            val result = respone.call.receive<BaseApiModel>()
            if (result.status == 200) {
                return Resource.success(result, result.message)
            } else {
                return Resource.error(result.message, result)
            }
        }
        return Resource.error("Some Error Occurred")
    }
}
