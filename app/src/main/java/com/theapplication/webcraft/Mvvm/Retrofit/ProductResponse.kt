package com.theapplication.webcraft.Mvvm.Retrofit



sealed class ProductResponse<out T> {
    data class Sucess <out T>(val data: T):ProductResponse<T>()
    data class Errors(val message:String):ProductResponse<Nothing>()
    object loading:ProductResponse<Nothing>()
}