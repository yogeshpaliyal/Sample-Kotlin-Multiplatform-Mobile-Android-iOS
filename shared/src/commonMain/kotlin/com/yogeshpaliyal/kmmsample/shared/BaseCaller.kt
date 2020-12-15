package com.yogeshpaliyal.kmmsample.shared

import com.yogeshpaliyal.kmmsample.shared.data.BaseApiModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.DefaultRequest.Feature.install
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

open class BaseCaller {
    private val params by lazy {
        HashMap<String, String>()
    }

    suspend fun apiCall(api: String): Resource<BaseApiModel> {
        val httpClient = HttpClient {

        }

        val respone = httpClient.request<HttpResponse> {
            url(api)
            method = HttpMethod.Get
            accept(ContentType.Application.Json)
            /*install(JsonFeature) {
                serializer = JacksonSerializer {
                }
            }*/
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


      //  val result = respone.call.receive<String>()


        if (respone.status == HttpStatusCode.OK) {
            val result = respone.call.receive<BaseApiModel>()
            if (result is BaseApiModel)
                if (result.status == 200) {
                    return Resource.success(result, result.message)
                } else {
                    return Resource.error(result.message, result)
                }
        }
        return Resource.error("Some error occurred")
    }
}
