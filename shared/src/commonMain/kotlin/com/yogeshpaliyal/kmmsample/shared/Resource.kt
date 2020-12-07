package com.yogeshpaliyal.kmmsample.shared


/*
CREATED BY : yogesh ON 06/08/20 11:35 AM
*/

data class Resource<out T>(var status: Status, val data: T?, var message: String?) {

    companion object {

        fun <T> success(data: T?, message: String?= ""): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                message
            )
        }

        fun <T> create(status: Status, data: T?, message: String?= ""): Resource<T> {
            return Resource(status, data, message)
        }

       /* fun <T> cancel(): Resource<T> {
            return Resource(
                Status.REQUEST_CANCEL,
                null,
                null
            )
        }*/

        fun <T> error(msg: String? = "", data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                msg
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }

    }
}