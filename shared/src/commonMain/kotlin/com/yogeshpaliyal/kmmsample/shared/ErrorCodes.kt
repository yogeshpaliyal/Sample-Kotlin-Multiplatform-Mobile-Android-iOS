package com.yogeshpaliyal.kmmsample.shared


/*
* @author Yogesh Paliyal
* techpaliyal@gmail.com
* https://techpaliyal.com
* created on 17-12-2020 07:36
*/
annotation class ErrorCodes{
    companion object{
        const val PARSING_ERROR = "PARSING_ERROR"
        const val SERVER_ERROR = "SERVER_ERROR"
        const val UNKNOWN_ERROR = "UNKNOWN_ERROR"
    }
}