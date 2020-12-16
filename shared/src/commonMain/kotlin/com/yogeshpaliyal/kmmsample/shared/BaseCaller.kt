package com.yogeshpaliyal.kmmsample.shared

import com.yogeshpaliyal.kmmsample.shared.data.BaseApiModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.DefaultRequest.Feature.install
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

open class BaseCaller {
    private val params by lazy {
        HashMap<String, String>()
    }

    suspend fun apiCall(api: String): Resource<BaseApiModel> {
        val httpClient = HttpClient {
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }



       /* val respone = httpClient.request<HttpResponse> {
            url(api)
            method = HttpMethod.Get
            accept(ContentType.Application.Json)
        }
*/
        try {
            val response = httpClient.get<BaseApiModel>(api) {
                accept(ContentType.Application.Json)
            }

            if (response.status == 200) {
                return Resource.success(response, response.message)
            } else {
                return Resource.error(response.message, response)
            }
        }catch (e:Exception){
            e.printStackTrace()
            return Resource.error(e.message)
        }
    }
}
