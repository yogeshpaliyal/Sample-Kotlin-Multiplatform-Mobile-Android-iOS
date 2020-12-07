package com.yogeshpaliyal.kmmsample.shared


/*
* @author Yogesh Paliyal
* techpaliyal@gmail.com
* https://techpaliyal.com
* created on 07-12-2020 22:59
*/

class SampleCaller: BaseCaller() {

    suspend fun callApi() =    apiCall("https://app.fakejson.com/q")


}