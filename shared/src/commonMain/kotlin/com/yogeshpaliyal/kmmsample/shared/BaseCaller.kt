package com.yogeshpaliyal.kmmsample.shared

import com.yogeshpaliyal.kmmsample.shared.data.BaseApiModel
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.SerializationException

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
           /* install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.HEADERS
            }*/
        }

        try {

            /*val request = httpClient.request<HttpResponse> {
                url(api)
                method = HttpMethod.Get
                accept(ContentType.Application.Json)
            }*/

            val response = httpClient.get<BaseApiModel>(api) {
                accept(ContentType.Application.Json)
                params.forEach {
                    parameter(it.key,it.value)
                }
            }

                if (response.status == 200) {
                    return Resource.success(response, response.message)
                } else {
                    return Resource.error(response.message, response,ErrorCodes.SERVER_ERROR)
                }

        }catch (e: SerializationException) {
            e.printStackTrace()
            return Resource.error(errorCode = ErrorCodes.PARSING_ERROR)
        }catch (e:Exception){
            e.printStackTrace()
            return Resource.error("Some error occurred",errorCode = ErrorCodes.UNKNOWN_ERROR)
        }
    }
}
