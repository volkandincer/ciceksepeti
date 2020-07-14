package com.example.ciceksepeti.response

data class Result (val data: Data)
data class Error(val type: Int,val title: String, val message: String, val returnUrl:String)
data class ApiResult<out T>(val data: T?, val error: Error?)
class ApiError(val error: Error?) : Throwable()
